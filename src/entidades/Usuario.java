
package entidades;

import tabela.ObjetoTabela;


public class Usuario implements ObjetoTabela{
    
    private Categoria categoria;
    private String login;
    private String senha;
    private int idUsuario;

   
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    

    public String getLogin() {
        return login;
    }

    public void setLogin(String Login) {
        this.login = Login;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
      public static String[] COLUNAS = {"Usuario", "Categoria"};
    
    @Override
    public Object valor(int coluna) {
        switch (coluna) {
            case 0:
                return login;
            case 1: 
                return categoria;
         default:
             return " - ";
        }
    }

    @Override
    public String toString() {
        return login;
    }
    
    
    
    

}
