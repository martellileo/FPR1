package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoa = new Pessoa();
    
    private Pessoa pessoaAutenticada;

    public String autenticar() {
        this.pessoaAutenticada = pessoaDAO.autenticar(pessoa.getLogin(), pessoa.getSenha());
        return "/index";
    }

    public String logout() {
        this.pessoaAutenticada = null;
        return "/index";
    }

    public boolean usuarioLogado() {
        return pessoaAutenticada != null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Pessoa getPessoaAutenticada() {
        return pessoaAutenticada;
    }
}
