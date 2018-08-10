/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import tabela.ObjetoTabela;

/**
 *
 * @author Lab03c
 */
public class Livro implements ObjetoTabela{
    
    private int idLivro;
    private String titulo;
    private String isbn;
    private String assunto;
    private String autores; 
    private int exemplar;

    
    

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getExemplar() {
        return exemplar;
    }

    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }
    
    public static String[] COLUNAS = {"Titulo", "Autores"};
    
    @Override
    public Object valor(int coluna) {
        switch (coluna) {
            case 0:
                return titulo;
            case 1:
                return autores;
         default:
             return " - ";
        }
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    
    
}
