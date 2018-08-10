/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import tabela.ObjetoTabela;

/**
 *
 * @author Lab03c
 */
public class Emprestimo implements ObjetoTabela{
    
    private int idEmprestimo;
    private Date devolucao;
    private Date emprestimo;
    
    private Usuario usuario;
    private Livro livro;


    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date Devolucao) {
        this.devolucao = Devolucao;
    }

    public Date getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Date Emprestimo) {
        this.emprestimo = Emprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public static String[] COLUNAS = {"Livro", "Usuario","Emprestimo","Devolução"};
    
    
    public Object valor(int coluna) {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        switch (coluna) {
            case 0:
                return livro;
            case 1: 
                return usuario;
            case 2: 
                return format.format(emprestimo);   
            case 3: 
                return format.format(devolucao);
                
         default:
             return " - ";
        }
    }

    @Override
    public String toString() {
        return "Emprestimo do livro = " + livro + '}';
    }

    
    
            
    
}
