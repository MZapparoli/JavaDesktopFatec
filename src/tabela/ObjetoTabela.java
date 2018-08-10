/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

/**
 * Deve ser implementado por suas Entidades
 * Faz com que ela possa ser representada visualmente numa tabela
 * 
 * @author Matheus
 */
public interface ObjetoTabela {
   
    // Cada coluna é um atributo (nome, descricao, etc) que você deseja exibir
    Object valor(int coluna);
    
}
