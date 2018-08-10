/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CadastroUsuario {

    private Conexao con = new Conexao();
    CadastroCategoria cadastro = new CadastroCategoria();

    /**
     * Retorna UMA usuario do banco de dados
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Usuario consultarUsuario(int id) throws SQLException {
        Usuario usuario = null;
        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select * from usuario "
                    + " where idUsuario = ?");
            st.setInt(i++, id);
            rs = st.executeQuery();

            // Se fosse mais de uma usuario para ser retornada,
            // usuaríamos while(rs.next)
            // que é uam estrutura de repetição.
            // if (rs.next) pega o primeiro resultado apenas,
            // oque da certo quando colocamos um where idUsuario = paramId
            // afinas, o id é único na tabela
            if (rs.next()) {
                // pega os dados da Linha e coloca nessa instância de Usuario
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCategoria(cadastro.consultarCategoria(rs.getInt("categoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    
    public Usuario consultarUsuario(String nome, String senha){
        Usuario usuario = null;
        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select * from usuario "
                    + " where login = ? and senha = ?");
            st.setString(i++, nome);
            st.setString(i++, senha);
            rs = st.executeQuery();


            if (rs.next()) {
                // pega os dados da Linha e coloca nessa instância de Usuario
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCategoria(cadastro.consultarCategoria(rs.getInt("categoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    /**
     *
     * @return Uma lista de Categorias
     */
    public LinkedList consultarTodosUsuarios() {
        PreparedStatement st;
        ResultSet rs;
        // LinkedList é uma estrutura de dados que representa uma Lista de dados
        LinkedList lista = new LinkedList();
        try {
            st = con.getConexao().prepareStatement("select * from usuario");
            rs = st.executeQuery();

            // percore o ResultSet (ConjuntoDeResultados) linha-a-linha
            while (rs.next()) {
                // cria uma nova instância de usuario a cada linha iterada
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCategoria(cadastro.consultarCategoria(rs.getInt("categoria")));
                // adiciona usuario na lista
                lista.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     * Salva uma usuario no banco de dados
     *
     * @param usuario
     * @return id gerado no INSERT
     */
    public int salvarUsuario(Usuario usuario) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // idUsuario omitido pois ela é Auto_Incremente é gerado pelo MySQL
            st = con.getConexao().prepareStatement("INSERT INTO usuario ("
                    + "login, senha, categoria) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // Statement.RETURN_GENERATED_KEYS faz com que o id criado seja retornado
            
            st.setString((i++), usuario.getLogin());
            st.setString((i++), usuario.getSenha());
            st.setInt(i++, usuario.getCategoria().getIdCategoria());

            // executa o statement
            st.executeUpdate();

            // pega o id retornado
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        // 0 siginifica que nenhum id foi gerado
        // teste se o método deu certo comparando idGerado > 0
        return 0;
    }

    /**
     * Atualiza uma usuario no banco de dados
     *
     * @param usuario
     */
    public int atualizarUsuario(Usuario usuario) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {
            // UPDATE de uma entidade deve especificar qual 
            // usuario será atualizada.
            // WHERE idUsuario = ?
            st = con.getConexao().prepareStatement(
                    "UPDATE usuario SET login = ?, senha = ?, categoria = ? "
                    + "WHERE idUsuario = ?");

            // passa os valores pro comando
            st.setString((i++), usuario.getLogin());
            st.setString((i++), usuario.getSenha());
            st.setInt(i++, usuario.getCategoria().getIdCategoria());
            st.setInt(i++, usuario.getIdUsuario());

            // no UPDATE, o comando executeUpdate executa o comando no BD e
            // retorna quantas linhas foram afetadas pelo seu comando
            // Deve ser > 0
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    public int excluirUsuario(int idUsuario) {

        PreparedStatement st;
        ResultSet rs;
        int i = 1;

        try {

            st = con.getConexao().prepareStatement(
                    "DELETE FROM usuario "
                    + "WHERE idUsuario = ?");

            st.setInt(i++, idUsuario);


            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
