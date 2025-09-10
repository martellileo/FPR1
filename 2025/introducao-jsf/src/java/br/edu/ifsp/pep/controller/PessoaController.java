package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.DAO.PessoaDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;

@Named
@SessionScoped
public class PessoaController implements Serializable {

    private Pessoa pessoa = new Pessoa();

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
