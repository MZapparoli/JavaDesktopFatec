/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import entidades.Categoria;
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
public class CadastroCategoria {

    private Conexao con = new Conexao();

    /**
     * Retorna UMA categoria do banco de dados
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Categoria consultarCategoria(int id) throws SQLException {
        Categoria categoria = null;
        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select * from categoria "
                    + " where idCategoria = ?");
            st.setInt(i++, id);
            rs = st.executeQuery();

            // Se fosse mais de uma categoria para ser retornada,
            // usuaríamos while(rs.next)
            // que é uam estrutura de repetição.
            // if (rs.next) pega o primeiro resultado apenas,
            // oque da certo quando colocamos um where idCategoria = paramId
            // afinas, o id é único na tabela
            if (rs.next()) {
                // pega os dados da Linha e coloca nessa instância de Categoria
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setPeriodo(rs.getInt("periodo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    /**
     *
     * @return Uma lista de Categorias
     */
    public LinkedList consultarTodasCategorias() {
        PreparedStatement st;
        ResultSet rs;
        // LinkedList é uma estrutura de dados que representa uma Lista de dados
        LinkedList lista = new LinkedList();
        try {
            st = con.getConexao().prepareStatement("select * from categoria");
            rs = st.executeQuery();

            // percore o ResultSet (ConjuntoDeResultados) linha-a-linha
            while (rs.next()) {
                // cria uma nova instância de categoria a cada linha iterada
                Categoria categoria = new Categoria();

                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setPeriodo(rs.getInt("periodo"));
                // adiciona categoria na lista
                lista.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     * Salva uma categoria no banco de dados
     *
     * @param categoria
     * @return id gerado no INSERT
     */
    public int salvarCategoria(Categoria categoria) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // idCategoria omitido pois ela é Auto_Incremente é gerado pelo MySQL
            st = con.getConexao().prepareStatement("INSERT INTO categoria ("
                    + "descricao, periodo) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            // Statement.RETURN_GENERATED_KEYS faz com que o id criado seja retornado
            st.setString((i++), categoria.getDescricao());
            st.setInt(i++, categoria.getPeriodo());

            // executa o statement
            st.executeUpdate();

            // pega o id retornado
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);

        }
        // 0 siginifica que nenhum id foi gerado
        // teste se o método deu certo comparando idGerado > 0
        return 0;
    }

    /**
     * Atualiza uma categoria no banco de dados
     *
     * @param categoria
     */
    public int atualizarCategoria(Categoria categoria) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // UPDATE de uma entidade deve especificar qual 
            // categoria será atualizada.
            // WHERE idCategoria = ?
            st = con.getConexao().prepareStatement(
                    "UPDATE categoria SET descricao = ?, periodo = ? "
                    + "WHERE idCategoria = ?");

            // passa os valores pro comando
            st.setString((i++), categoria.getDescricao());
            st.setInt(i++, categoria.getPeriodo());
            st.setInt(i++, categoria.getIdCategoria());

            // no UPDATE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Exclui uma categoria no banco de dados
     *
     * @param categoria
     */
    public int excluirCategoria(int idCategoria) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // DELETE remove uma linha do BD
            // IMPORTANTE filtrar
            st = con.getConexao().prepareStatement(
                    "DELETE FROM categoria "
                    + "WHERE idCategoria = ?");

            // passa os valores pro comando
            st.setInt(i++, idCategoria);

            // no DELETE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
