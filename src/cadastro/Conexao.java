/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab03c
 */
public class Conexao {

    private Connection con;

    public Conexao() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhopoo",
                    "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConexao() {
        return con;
    }

}
