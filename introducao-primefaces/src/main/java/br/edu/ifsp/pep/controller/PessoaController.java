package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named //ManageBean
//@RequestScoped //Escopo do tipo Request
@ViewScoped //Escopo do tipo View
//@SessionScoped //Escopo do tipo session (para cada cliente)
//@ApplicationScoped //Escopo único para a aplicação
public class PessoaController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private List<Pessoa> pessoas = new ArrayList<>();
    private Pessoa pessoaSelecionada;

    private Pessoa pessoa = new Pessoa();

    public PessoaController() {
        System.out.println("Construtor Pessoa Controller.");
    }

    public void exibir() {
        System.out.println("Método exibir");
        // if(pessoaSelecionada != null)
        System.out.println(getPessoaSelecionada().getNome());

    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public void adicionar() {
        System.out.println("Método adicionar");
        this.pessoas.add(this.pessoa);

        //Insere no BD
        pessoaDAO.inserir(pessoa);

        //Criar nova pessoa
        this.pessoa = new Pessoa();
        
        Mensagem.sucesso("Pessoa Cadastrada", "Sucesso");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void deletar() {
        System.out.println(pessoaSelecionada.getNome());
        pessoaDAO.excluir(pessoaSelecionada);
    }

}
