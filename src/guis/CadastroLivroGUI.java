/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import controlador.Controlador;
import entidades.Livro;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import tabela.ModeloTabela;
import tabela.ObjetoTabela;
import tabela.TableCellRenderer;

/**
 * Classe responsavel por Consultar, Salvar, Atualizar e Excluir livros
 *
 * Como funciona: Consultar: Ao abrir a janela, carregar os dados da Tabela.
 *
 * @author Matheus
 */
public class CadastroLivroGUI extends javax.swing.JFrame {

    // cada CadastroXXXGUI tem que ter uma instância de Controlador
    // acessa o banco de dados por você e tem regras de validação
    private Controlador controlador = new Controlador();

    // Livro Selecionada quando clicamos na tabela
    private Livro livroSelecionado = new Livro();

    public CadastroLivroGUI() {
        initComponents();
        // estado inicial da sua tela
        novoLivro();
        configuracoesVisuaisDaTabela();
        carregarDadosNaTabela();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txIsbn = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txExemplar = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txAssunto = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txAutor = new javax.swing.JFormattedTextField();
        txTitulo = new javax.swing.JFormattedTextField();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Livros");

        jLabel2.setText("Titulo");

        jLabel3.setText("Isbn");

        btAtualizar.setText("Atualizar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLivro);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel4.setText("Assunto");

        jLabel5.setText("Exemplar");

        jLabel6.setText("Autor");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txAutor)
                            .addComponent(txExemplar)
                            .addComponent(txAssunto)
                            .addComponent(txIsbn)
                            .addComponent(txTitulo))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizar)
                    .addComponent(btSalvar)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(btVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Salvar: 1) Valide e pegue os dados os Txts, , crie uma instância de Livro
     * com eles ; 2) Salve a livro; 3) Cheque para ver se funcionou como
     * retorno; 4a) Se funcionou, mostre uma mensagem, limpe a tela e carregue a
     * tabela. Desabilitados Excluir e Atualizar; 4b) Se não funcinou, apenas
     * mostre uma mensagem de erro.
     *
     */
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // Validar
        if (txTitulo.getText().isEmpty() || txIsbn.getText().isEmpty()
                || txTitulo.getText().isEmpty() || txAutor.getText().isEmpty()
                || txExemplar.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campos não podem estar vazios!");
            return;
        }

        // Pegar os dados e criar instância
        Livro livro = new Livro();
        String titulo = txTitulo.getText();
        livro.setTitulo(titulo);
        String isbn = txIsbn.getText();
        livro.setIsbn(isbn);
        String assunto = txAssunto.getText();
        livro.setAssunto(assunto);
        String autor = txAutor.getText();
        livro.setAutores(autor);

        // Converter texto em número - validar se é num válido e não texto
        String exemplar = txExemplar.getText();
        try {
            int exemplarI = Integer.parseInt(exemplar);
            livro.setExemplar(exemplarI);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Exemplar deve ser um número válido");
            // return assim interrompe a execução do método
            return;
        }

        // Salvando livro - se uma vez vc n encontrar o método que precisa
        // em controlador, crie.
        boolean salvou = controlador.salvarLivro(livro);

        //Testa se salvou
        if (salvou) {
            // volta a tela ao estado inicial
            novoLivro();
            // recarrega a tabela para mostrar o novo registro
            carregarDadosNaTabela();
            // mostra mensagem
            JOptionPane.showMessageDialog(null,
                    "Livro " + titulo + " salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar livro. Tente novamente");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    /**
     * Seleciona uma livro na tabela 1) Clica e seleciona uma livro, passamos
     * para o objeto livroSelecionado, um atributo da classe Gui; 2) Com uma
     * livro selecionada, algumas coisas acontecem: Habilitar excluir, Carregar
     * os campos com a descrição e o período e Habilitar atualizar e desabilitar
     * Salvar.
     *
     * @param evt
     */
    private void tbLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivroMouseClicked
        // Recuperamos o ModeloTabela que passamos para tbLivro,
        //    fazendo a conversão
        ModeloTabela nossoModeloTabgela = (ModeloTabela) tbLivro.getModel();

        // pega a linha selecionada
        // se nenhuma estiver, o valor é -1
        int linhaSelecionada = tbLivro.getSelectedRow();
        if (linhaSelecionada == -1) {
            return;
        }
        ObjetoTabela valor = nossoModeloTabgela.getValor(linhaSelecionada);
        // Podemos converter ObjetoValor para nossa Entidade Livro
        livroSelecionado = (Livro) valor;

        // Colocamos os campos de livro na tela
        txTitulo.setText(livroSelecionado.getTitulo());
        txIsbn.setText(livroSelecionado.getIsbn());
        txAssunto.setText(livroSelecionado.getAssunto());
        txAutor.setText(livroSelecionado.getAutores());

        // tem que ser String no setText, por isso a conversão
        txExemplar.setText(Integer.toString(livroSelecionado.getExemplar()));
        // se fosse um combobox, o código seria um pouco diferente.

        // habilitar e desabilitar botões
        btExcluir.setEnabled(true);
        btAtualizar.setEnabled(true);

        // habilitar botões que podem ser utilizados
        btSalvar.setEnabled(false);


    }//GEN-LAST:event_tbLivroMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novoLivro();
    }//GEN-LAST:event_btNovoActionPerformed

    /**
     * Atualizar Lógica PARECIDA com o inserir.
     *
     *
     * @param evt
     */
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        // Validar
        if (txTitulo.getText().isEmpty() || txIsbn.getText().isEmpty()
                || txTitulo.getText().isEmpty() || txAutor.getText().isEmpty()
                || txExemplar.getText().isEmpty()) {
            return;
        }
        {

            // Pegar os dados e criar instância
            Livro livro = new Livro();

        // Como atualizar pega um objeto já existente no banco,
            // não podemos perder a informação do idLivro
            livro.setIdLivro(livroSelecionado.getIdLivro());

            String titulo = txTitulo.getText();
            livro.setTitulo(titulo);
            String isbn = txIsbn.getText();
            livro.setIsbn(isbn);
            String assunto = txAssunto.getText();
            livro.setAssunto(assunto);
            String autor = txAutor.getText();
            livro.setAutores(autor);

            // Converter texto em número - validar se é num válido e não texto
            String exemplarTexto = txExemplar.getText();
            try {
                int exemplar = Integer.parseInt(exemplarTexto);
                livro.setExemplar(exemplar);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Exemplar deve ser um número válido");
                // return assim interrompe a execução do método
                return;
            }

        // Salvando livro - se uma vez vc n encontrar o método que precisa
            // em controlador, crie.
            boolean atualizou = controlador.atualizarLivro(livro);

            //Testa se salvou
            if (atualizou) {
                // volta a tela ao estado inicial
                novoLivro();
                // recarrega a tabela para mostrar o registro atualizado
                carregarDadosNaTabela();
                // mostra mensagem
                JOptionPane.showMessageDialog(null,
                        "Livro " + titulo + " atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Erro ao atualizar livro. Tente novamente");
            }
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    /**
     * Excluir 1) Perguntar primeiro 2) Se sim, excluir 3) voltar a tela no
     * estado inicial
     *
     */
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null,
                "Deseja excluir a livro "
                + livroSelecionado.getTitulo()+ "?");
        boolean deveExcluir = opcaoEscolhida == JOptionPane.OK_OPTION;
        if (!deveExcluir) {
            // não faz nada
            return;
        }
        boolean livroExcluida = controlador.excluirLivro(livroSelecionado);
        // se o registro de livro no BD estiver sendo referenciado em outras tabelas,
        // vai dar erro.

        if (livroExcluida) {
            JOptionPane.showMessageDialog(null,
                    "Livro " + livroSelecionado.getTitulo()+ " excluída com sucesso.");
            // volta a tela ao estado inicial
            novoLivro();
            // recarrega a tabela para mostrar o registro atualizado
            carregarDadosNaTabela();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao excluír livro " + livroSelecionado.getTitulo()+ ".");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        PrincipalGUI novo = new PrincipalGUI();
        novo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    /**
     * Não é um evento, é um método a parte que é utilizado dentro de outros
     * eventos, como o salvar, excluir e clique no botão novo
     */
    private void novoLivro() {
        // desabilita botoes que não podem ser utilizados
        btExcluir.setEnabled(false);
        btAtualizar.setEnabled(false);

        // habilitar botões que podem ser utilizados
        btSalvar.setEnabled(true);

        // limpa os campos
        txIsbn.setText("");
        txAssunto.setText("");
        txAutor.setText("");
        txExemplar.setText("");
        txTitulo.setText("");

        // reseta a livro selecionada
        livroSelecionado = new Livro();
    }

    /**
     * Não é um evento, é um método a parte que é utilizado dentro de outros
     * eventos, como o salvar, excluir e clique no botão novo
     */
    private void carregarDadosNaTabela() {
        // Puxa dados do controlador, que vem do CadastroXXX, do banco
        LinkedList livros = controlador.consultarLivros();

        // Instancia um Model
        ModeloTabela modeloTabela = new ModeloTabela(livros, Livro.COLUNAS);

        // Configura modelo na tabela
        tbLivro.setModel(modeloTabela);
    }

    /**
     * Não é um evento, é um método a parte que é utilizado na primeira vez que
     * a janela abre, portanto, executado UMA UNICA VEZ
     */
    private void configuracoesVisuaisDaTabela() {
        // manual de tabelas
        tbLivro.setColumnSelectionAllowed(false);
        tbLivro.getTableHeader().setReorderingAllowed(false);
        tbLivro.setDefaultRenderer(Object.class, new TableCellRenderer());
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbLivro;
    private javax.swing.JFormattedTextField txAssunto;
    private javax.swing.JFormattedTextField txAutor;
    private javax.swing.JFormattedTextField txExemplar;
    private javax.swing.JFormattedTextField txIsbn;
    private javax.swing.JFormattedTextField txTitulo;
    // End of variables declaration//GEN-END:variables

}
