package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.DAO.PessoaDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class PessoaController {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;

    @Inject()
    private PessoaDAO pessoaDAO;
    

    public PessoaController() {
        System.out.println("Construtor");
    }

    public void incrementar() {
        pessoa.setCodigo(pessoa.getCodigo() + 1);
        System.out.println("Numero: " + pessoa.getCodigo());
    }

    public void exibir() {
        System.out.println("Metodo Exibir");
        System.out.println(pessoa);
    }

    public void adicionarPessoa() {

        if (pessoa.getNome().length() < 5) {
            Mensagem.warning("Nome da pessoa deve conter mais que cinco caracteres", "");
        } else {
            pessoaDAO.inserir(pessoa);
            Mensagem.sucesso("Sucesso", "Pessoa cadastrada no banco de dados");
            pessoa = new Pessoa();
        }
    }
    
    public void excluir(Pessoa pessoa){
        System.out.println(pessoa);
        pessoaDAO.remover(pessoa);
        Mensagem.sucesso("Sucesso", "Pessoa removida do banco de dados");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        System.out.println("Acessando bando de dados.....");
        this.pessoas = pessoaDAO.buscarTodas();

        return this.pessoas;
    }
    
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
