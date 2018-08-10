/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 * DefaultTableModel é um model usado pelo JTable
 * Esse é um mecanismo de Model de Tabela genérico
 * 
 * @author Matheus
 */
public class ModeloTabela extends DefaultTableModel {
   
    // A JTable usa uma LinkedList (o mesmo tipo que seus CadastrosXXX retornam)
    // quando você faz uma consulta no banco de dados.
    private LinkedList<ObjetoTabela> lista;

    public ModeloTabela(LinkedList lista, Object[] colunas) {
        super(colunas, 0);
        this.lista = lista;
    }
    
    // Método para você recuperar o item selecionado da tabela
    // Você pode fazer uma conversão de ObjetoTabela para qualquer Entidade
    // que estiver armazenada sua.
    public ObjetoTabela getValor(int row) {
        return lista.get(row);
    }
    // Os métodos abaixo são sobrepostos da classe DefualtTableModel
    @Override
    public Object getValueAt(int row, int column) {
        return lista.get(row).valor(column);
    }

    @Override
    public int getRowCount() {
        return lista != null ? lista.size() : 0;
    }
    
    
    
}
