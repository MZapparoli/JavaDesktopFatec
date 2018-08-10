/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import entidades.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Todos os códigos relacionados a SQL devem estar nas classes CadastroXXX XXX =
 * sua entidade
 *
 * Consultas, inserção, atualização e remoção de dados.
 *
 * @author Lab03c
 */
public class CadastroLivro {

    private Conexao con = new Conexao();

    /**
     * Retorna UMA livro do banco de dados
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Livro consultarLivro(int id) throws SQLException {
        Livro livro = null;
        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select * from livro "
                    + " where idLivro = ?");
            st.setInt(i++, id);
            rs = st.executeQuery();

            if (rs.next()) {
                // pega os dados da Linha e coloca nessa instância de livro
                livro = new Livro();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAssunto(rs.getString("assunto"));
                livro.setAutores(rs.getString("autores"));
                livro.setExemplar(rs.getInt("exemplar"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livro;
    }

    /**
     *
     * @return Uma lista de livros
     */
    public LinkedList consultarTodoslivros() {
        PreparedStatement st;
        ResultSet rs;
        // LinkedList é uma estrutura de dados que representa uma Lista de dados
        LinkedList lista = new LinkedList();
        try {
            st = con.getConexao().prepareStatement("select * from livro");
            rs = st.executeQuery();

            // percore o ResultSet (ConjuntoDeResultados) linha-a-linha
            while (rs.next()) {
                // cria uma nova instância de livro a cada linha iterada
                Livro livro = new Livro();

                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAssunto(rs.getString("assunto"));
                livro.setAutores(rs.getString("autores"));
                livro.setExemplar(rs.getInt("exemplar"));
                // adiciona livro na lista
                lista.add(livro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroLivro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     * Salva uma livro no banco de dados
     *
     * @param livro
     * @return id gerado no INSERT
     */
    public int salvarLivro(Livro livro) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // idlivro omitido pois ela é Auto_Incremente é gerado pelo MySQL
            st = con.getConexao().prepareStatement("INSERT INTO livro ("
                    + "titulo, isbn, assunto, autores, exemplar) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // Statement.RETURN_GENERATED_KEYS faz com que o id criado seja retornado
            st.setString((i++), livro.getTitulo());
            st.setString(i++, livro.getIsbn());
            st.setString(i++, livro.getAssunto());
            st.setString(i++, livro.getAutores());
            st.setInt(i++, livro.getExemplar());
            

            // executa o statement
            st.executeUpdate();

            // pega o id retornado
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroLivro.class.getName()).log(Level.SEVERE, null, ex);

        }
        // 0 siginifica que nenhum id foi gerado
        // teste se o método deu certo comparando idGerado > 0
        return 0;
    }

    /**
     * Atualiza uma livro no banco de dados
     *
     * @param livro
     */
    public int atualizarLivro(Livro livro) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // UPDATE de uma entidade deve especificar qual 
            // livro será atualizada.
            // WHERE idlivro = ?
            st = con.getConexao().prepareStatement(
                    "UPDATE livro SET titulo = ?, isbn = ?, assunto = ?, autores = ?, exemplar = ? "
                    + "WHERE idLivro = ?");

            // passa os valores pro comando
            st.setString((i++), livro.getTitulo());
            st.setString((i++), livro.getIsbn());
            st.setString((i++), livro.getAssunto());
            st.setString((i++), livro.getAutores());
            st.setInt(i++, livro.getExemplar());
            st.setInt(i++, livro.getIdLivro());

            // no UPDATE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Exclui uma livro no banco de dados
     *
     * @param livro
     */
    public int excluirLivro(int idLivro) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // DELETE remove uma linha do BD
            // IMPORTANTE filtrar
            st = con.getConexao().prepareStatement(
                    "DELETE FROM livro "
                    + "WHERE idLivro = ?");

            // passa os valores pro comando
            st.setInt(i++, idLivro);

            // no DELETE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
