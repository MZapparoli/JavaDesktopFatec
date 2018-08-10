/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import controlador.Controlador;
import entidades.Categoria;
import entidades.Usuario;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import tabela.ModeloTabela;
import tabela.ObjetoTabela;
import tabela.TableCellRenderer;

/**
 * Classe responsavel por Consultar, Salvar, Atualizar e Excluir categorias
 *
 * Como funciona: Consultar: Ao abrir a janela, carregar os dados da Tabela.
 *
 * @author Matheus
 */
public class CadastroUsuarioGUI extends javax.swing.JFrame {

    // cada CadastroXXXGUI tem que ter uma instância de Controlador
    // acessa o banco de dados por você e tem regras de validação
    private Controlador controlador = new Controlador();

    // Usuario Selecionada quando clicamos na tabela
    private Usuario usuarioSelecionado = new Usuario();

    public CadastroUsuarioGUI() {
        initComponents();
        // estado inicial da sua tela
        carregarCategorias();
        novoUsuario();
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
        txLogin = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        cbCategoria = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Usuario");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        txLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txLoginActionPerformed(evt);
            }
        });

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

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        jScrollPane2.setViewportView(jScrollPane1);

        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Categoria");

        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSenhaActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txLogin)
                            .addComponent(txSenha))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizar)
                    .addComponent(btSalvar)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Salvar: 1) Valide e pegue os dados os Txts, , crie uma instância de
     * Usuario com eles ; 2) Salve a categoria; 3) Cheque para ver se funcionou
     * como retorno; 4a) Se funcionou, mostre uma mensagem, limpe a tela e
     * carregue a tabela. Desabilitados Excluir e Atualizar; 4b) Se não
     * funcinou, apenas mostre uma mensagem de erro.
     *
     */
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // Validar
        if (txLogin.getText().isEmpty() || txSenha.getPassword() == null && txSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Campos não podem estar vazios!");
            return;
        }

        // Pegar os dados e criar instância
        Usuario usuario = new Usuario();
        String login = txLogin.getText();
        String senha = new String(txSenha.getPassword()).intern();
        Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
        
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setCategoria(categoria);

        boolean salvou = controlador.salvarUsuario(usuario);

        //Testa se salvou
        if (salvou) {
            // volta a tela ao estado inicial
            novoUsuario();
            // recarrega a tabela para mostrar o novo registro
            carregarDadosNaTabela();
            // mostra mensagem
            JOptionPane.showMessageDialog(null,
                    "Usuario " + login + " salva com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar Usuario. Tente novamente");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    /**
     * Seleciona uma categoria na tabela 1) Clica e seleciona uma categoria,
     * passamos para o objeto UsuarioSelecionado, um atributo da classe Gui; 2)
     * Com uma categoria selecionada, algumas coisas acontecem: Habilitar
     * excluir, Carregar os campos com a descrição e o período e Habilitar
     * atualizar e desabilitar Salvar.
     *
     * @param evt
     */
    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        // Recuperamos o ModeloTabela que passamos para tbCategoria,
        //    fazendo a conversão
        ModeloTabela nossoModeloTabela = (ModeloTabela) tbUsuario.getModel();

        // pega a linha selecionada
        // se nenhuma estiver, o valor é -1
        int linhaSelecionada = tbUsuario.getSelectedRow();
        if (linhaSelecionada == -1) {
            return;
        }
        ObjetoTabela valor = nossoModeloTabela.getValor(linhaSelecionada);
        usuarioSelecionado = (Usuario) valor;

        txLogin.setText(usuarioSelecionado.getLogin());
        txSenha.setText(usuarioSelecionado.getSenha());
        cbCategoria.getModel().setSelectedItem(usuarioSelecionado.getCategoria());

        // habilitar e desabilitar botões
        btExcluir.setEnabled(true);
        btAtualizar.setEnabled(true);

        // habilitar botões que podem ser utilizados
        btSalvar.setEnabled(false);


    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novoUsuario();
    }//GEN-LAST:event_btNovoActionPerformed

    /**
     * Atualizar Lógica PARECIDA com o inserir.
     *
     *
     * @param evt
     */
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        // Validar
        if (txLogin.getText().isEmpty() || txSenha.getPassword() == null && txSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Campos não podem estar vazios!");
            return;
        }

        // Pegar os dados e criar instância
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(usuarioSelecionado.getIdUsuario());
        String login = txLogin.getText();
        String senha = new String(txSenha.getPassword()).intern();
        Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setCategoria(categoria);

        // Salvando categoria - se uma vez vc n encontrar o método que precisa
        // em controlador, crie.
        boolean atualizou = controlador.atualizarUsuario(usuario);

        //Testa se salvou
        if (atualizou) {
            // volta a tela ao estado inicial
            novoUsuario();
            // recarrega a tabela para mostrar o registro atualizado
            carregarDadosNaTabela();
            // mostra mensagem
            JOptionPane.showMessageDialog(null,
                    "Usuario " + login + " atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao atualizar Usuario. Tente novamente");
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    /**
     * Excluir 1) Perguntar primeiro 2) Se sim, excluir 3) voltar a tela no
     * estado inicial
     *
     */
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null,
                "Deseja excluir o usuario "
                + usuarioSelecionado.getLogin() + "?");
        boolean deveExcluir = opcaoEscolhida == JOptionPane.OK_OPTION;
        if (!deveExcluir) {
            // não faz nada
            return;
        }
        boolean categoriaExcluida = controlador.excluirUsuario(usuarioSelecionado);
        // se o registro de categoria no BD estiver sendo referenciado em outras tabelas,
        // vai dar erro.

        if (categoriaExcluida) {
            JOptionPane.showMessageDialog(null,
                    "Usuario " + usuarioSelecionado.getLogin() + " excluído com sucesso.");
            // volta a tela ao estado inicial
            novoUsuario();
            // recarrega a tabela para mostrar o registro atualizado
            carregarDadosNaTabela();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao excluír usuario " + usuarioSelecionado.getLogin() + ".");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void txLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txLoginActionPerformed

    private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrincipalGUI novo = new PrincipalGUI();
        novo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Não é um evento, é um método a parte que é utilizado dentro de outros
     * eventos, como o salvar, excluir e clique no botão novo
     */
    private void novoUsuario() {
        // desabilita botoes que não podem ser utilizados
        btExcluir.setEnabled(false);
        btAtualizar.setEnabled(false);

        // habilitar botões que podem ser utilizados
        btSalvar.setEnabled(true);

        // limpa os campos
        txSenha.setText("");
        txLogin.setText("");
        cbCategoria.setSelectedIndex(0);

        // reseta a categoria selecionada
        usuarioSelecionado = new Usuario();
    }

    /**
     * Não é um evento, é um método a parte que é utilizado dentro de outros
     * eventos, como o salvar, excluir e clique no botão novo
     */
    private void carregarDadosNaTabela() {
        // Puxa dados do controlador, que vem do CadastroXXX, do banco
        LinkedList usuarios = controlador.consultarUsuarios();

        // Instancia um Model
        ModeloTabela modeloTabela = new ModeloTabela(usuarios, Usuario.COLUNAS);

        // Configura modelo na tabela
        tbUsuario.setModel(modeloTabela);
    }

    /**
     * Não é um evento, é um método a parte que é utilizado na primeira vez que
     * a janela abre, portanto, executado UMA UNICA VEZ
     */
    private void configuracoesVisuaisDaTabela() {
        // manual de tabelas
        tbUsuario.setColumnSelectionAllowed(false);
        tbUsuario.getTableHeader().setReorderingAllowed(false);
        tbUsuario.setDefaultRenderer(Object.class, new TableCellRenderer());
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txLogin;
    private javax.swing.JPasswordField txSenha;
    // End of variables declaration//GEN-END:variables

    private void carregarCategorias() {

        LinkedList consultaCategorias = controlador.consultaCategorias();

        if (consultaCategorias.size() == 0) {
            btSalvar.setEnabled(false);
            return;

        }

        cbCategoria.setModel(new DefaultComboBoxModel(consultaCategorias.toArray()));

    }

}
