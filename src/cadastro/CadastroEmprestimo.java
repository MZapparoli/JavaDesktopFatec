/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import entidades.Emprestimo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CadastroEmprestimo {

    private Conexao con = new Conexao();
    CadastroUsuario cadastroUsuario = new CadastroUsuario();
    CadastroLivro cadastroLivro = new CadastroLivro();

    /**
     * Retorna UMA emprestimo do banco de dados
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Emprestimo consultarEmprestimo(int id) throws SQLException {
        Emprestimo emprestimo = null;
        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select * from emprestimo "
                    + " where idEmprestimo = ?");
            st.setInt(i++, id);
            rs = st.executeQuery();

            if (rs.next()) {
                // pega os dados da Linha e coloca nessa instância de Emprestimo
                emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setEmprestimo(rs.getDate("emprestimo"));
                emprestimo.setDevolucao(rs.getDate("devolucao"));
                emprestimo.setUsuario(cadastroUsuario.consultarUsuario(rs.getInt("usuario")));
                emprestimo.setLivro(cadastroLivro.consultarLivro(rs.getInt("livro")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emprestimo;
    }
    

    /**
     *
     * @return Uma lista de Categorias
     */
    public LinkedList consultarTodosEmprestimos() {
        PreparedStatement st;
        ResultSet rs;
        // LinkedList é uma estrutura de dados que representa uma Lista de dados
        LinkedList lista = new LinkedList();
        try {
            st = con.getConexao().prepareStatement("select * from emprestimo");
            rs = st.executeQuery();

            // percore o ResultSet (ConjuntoDeResultados) linha-a-linha
            while (rs.next()) {
                // cria uma nova instância de emprestimo a cada linha iterada
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setEmprestimo(rs.getDate("emprestimo"));
                emprestimo.setDevolucao(rs.getDate("devolucao"));
                emprestimo.setUsuario(cadastroUsuario.consultarUsuario(rs.getInt("usuario")));
                emprestimo.setLivro(cadastroLivro.consultarLivro(rs.getInt("livro")));
                // adiciona emprestimo na lista
                lista.add(emprestimo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     * Salva uma emprestimo no banco de dados
     *
     * @param emprestimo
     * @return id gerado no INSERT
     */
    public int salvarEmprestimo(Emprestimo emprestimo) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // idEmprestimo omitido pois ela é Auto_Incremente é gerado pelo MySQL
            st = con.getConexao().prepareStatement("INSERT INTO emprestimo ("
                    + "emprestimo, devolucao, usuario, livro) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // Statement.RETURN_GENERATED_KEYS faz com que o id criado seja retornado
            
            
            
            st.setDate(i++, new java.sql.Date (emprestimo.getEmprestimo().getTime()));
            st.setDate(i++, new java.sql.Date (emprestimo.getDevolucao().getTime()));
            st.setInt(i++, emprestimo.getUsuario().getIdUsuario());
            st.setInt(i++, emprestimo.getLivro().getIdLivro());

            // executa o statement
            st.executeUpdate();

            // pega o id retornado
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);

        }
        // 0 siginifica que nenhum id foi gerado
        // teste se o método deu certo comparando idGerado > 0
        return 0;
    }

    /**
     * Atualiza uma emprestimo no banco de dados
     *
     * @param emprestimo
     */
    public int atualizarEmprestimo(Emprestimo emprestimo) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // UPDATE de uma entidade deve especificar qual 
            // emprestimo será atualizada.
            // WHERE idEmprestimo = ?
            st = con.getConexao().prepareStatement(
                    "UPDATE emprestimo SET emprestimo = ?, devolucao = ?, usuario = ?, livro = ? "
                    + "WHERE idEmprestimo = ?");

            // passa os valores pro comando
            st.setDate(i++, new java.sql.Date (emprestimo.getEmprestimo().getTime()));
            st.setDate(i++, new java.sql.Date (emprestimo.getDevolucao().getTime()));
            st.setInt(i++, emprestimo.getUsuario().getIdUsuario());
            st.setInt(i++, emprestimo.getLivro().getIdLivro());
            st.setInt(i++, emprestimo.getIdEmprestimo());

            // no UPDATE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    public int excluirEmprestimo(int idEmprestimo) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {

            st = con.getConexao().prepareStatement(
                    "DELETE FROM emprestimo "
                    + "WHERE idEmprestimo = ?");

            st.setInt(i++, idEmprestimo);


            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
