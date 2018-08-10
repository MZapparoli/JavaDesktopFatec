/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import cadastro.CadastroCategoria;
import cadastro.CadastroEmprestimo;
import cadastro.CadastroLivro;
import cadastro.CadastroUsuario;
import entidades.Categoria;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Controlador que ajuda as GUIs a executarem sua lógica e falarem como BD
 *
 * Centralizamos todos os métodos aqui, mas não é necessário. Pode quebrar em
 * outros arquivos.
 *
 * Toda vez que uma GUI precisar chamar um método no banco, essa classe fará.
 * Declare todos os CadastrosXXX como Atributos desse classe.
 *
 * Se sua GUI precisar carregar uma lista de categorias, cria um método
 * consultaCategorias() e faça ele chamar a o método
 * CadastroCategoria.consultarTodasCategorias (Por exemplo)
 *
 * Imagine que outra GUI precise ter uma lista de todas categorias, pra carregar
 * e um ComboBox por exemplo. Ela poderia usar o método consultaCategorias() já
 * declarado aqui, economizando tempo de desenvolvimento.
 *
 * @author Matheus
 */
public class Controlador {

    private CadastroUsuario cadastroUsuario = new CadastroUsuario();
    private CadastroCategoria cadastroCategoria = new CadastroCategoria();
    private CadastroLivro cadastroLivro = new CadastroLivro();
    private CadastroEmprestimo cadastroEmprestimo = new CadastroEmprestimo();

    public boolean validaUsuario(String login, String senha) {
        Usuario local = cadastroUsuario.consultarUsuario(login, senha);

        if (local != null) {
            return true;
        }
        return false;
    }

    //Usuarios
    public LinkedList consultarUsuarios() {
        return cadastroUsuario.consultarTodosUsuarios();
    }

    public boolean salvarUsuario(Usuario usuario) {
        return cadastroUsuario.salvarUsuario(usuario) > 0;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        return cadastroUsuario.atualizarUsuario(usuario) > 0;
    }

    public boolean excluirUsuario(Usuario usuarioSelecionado) {
        return cadastroUsuario.excluirUsuario(usuarioSelecionado.getIdUsuario()) > 0;
    }

    // Livros
    public LinkedList consultarLivros() {
        return cadastroLivro.consultarTodoslivros();
    }

    public boolean salvarLivro(Livro livro) {
        return cadastroLivro.salvarLivro(livro) > 0;
    }

    public boolean atualizarLivro(Livro livro) {
        return cadastroLivro.atualizarLivro(livro) > 0;
    }

    public boolean excluirLivro(Livro livroSelecionado) {
        return cadastroLivro.excluirLivro(livroSelecionado.getIdLivro()) > 0;
    }

    //Categorias
    public LinkedList consultaCategorias() {
        return cadastroCategoria.consultarTodasCategorias();
    }

    // fazendo o teste de validade do Salvar diretamente no controlador 
    public boolean salvarCategoria(Categoria categoria) {
        // > 0 = true enntão é valido, senão é inválido
        return cadastroCategoria.salvarCategoria(categoria) > 0;
    }

    public boolean atualizarCategoria(Categoria categoria) {
        return cadastroCategoria.atualizarCategoria(categoria) > 0;
    }

    public boolean excluirCategoria(Categoria categoriaSelecionada) {
        return cadastroCategoria.excluirCategoria(categoriaSelecionada.getIdCategoria()) > 0;
    }

    //Emprestimos
    public LinkedList consultarEmprestimos() {
        return cadastroEmprestimo.consultarTodosEmprestimos();
    }

    public boolean salvarEmprestimo(Emprestimo emprestimo) {
        return cadastroEmprestimo.salvarEmprestimo(emprestimo) > 0;
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        return cadastroEmprestimo.atualizarEmprestimo(emprestimo) > 0;
    }

    public boolean excluirEmprestimo(Emprestimo emprestimoSelecionado) {
        return cadastroEmprestimo.excluirEmprestimo(emprestimoSelecionado.getIdEmprestimo()) > 0;
    }

}
