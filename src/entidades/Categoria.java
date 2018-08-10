/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import tabela.ObjetoTabela;

/**
 * Classe de Entidade.
 *  Por que entidade? Toda entidade representa um objeto no "mundo real"
 *  O que diferencia uma entidade de um objeto normal é que ela tem um ID,
 * um identificador único.
 *  Essa é uma Classe que equivale a tabela no banco de dados.
 *  Cada instância de categoria será preenchida com os dados de uma linha no BD
 * @author Lab03c
 */
public class Categoria implements ObjetoTabela {

    private String descricao;
    private int periodo;
    private int idCategoria;

    /*
    * Construtores para facilitar a instanciação
    */
    public Categoria() {
    }

    public Categoria(String descricao, int periodo) {
        this.descricao = descricao;
        this.periodo = periodo;
    }

    public Categoria(String descricao, int periodo, int idCategoria) {
        this.descricao = descricao;
        this.periodo = periodo;
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    // array estático público e final imutável, com nomes das colunas da tabela
    public static String[] COLUNAS = {"Descrição", "Período"};
    
    @Override
    public Object valor(int coluna) {
        switch (coluna) {
            case 0:
                return descricao;
            case 1:
                return periodo;
         default:
             return " - ";
        }
    }

    @Override
    public String toString() {
        return  descricao;
    }
    
    

}
