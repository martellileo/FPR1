package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
// @RequestScoped -> não precisa implementar serializable
//@ViewScoped -> escopo do tipo view
//@SessionScoped -> escopo do tipo session (para cada cliente)
@ApplicationScoped // escopo unico para a aplicação
public class PessoaController implements Serializable {
    
    @Inject
    private PessoaDAO pessoaDAO;

    private List<Pessoa> pessoas = new ArrayList<>();
    
    private Pessoa pessoa = new Pessoa();
    
    public PessoaController() {
        System.out.println("Construtor Pessoa Controller");
    }
    
    public void adicionar(){
        System.out.println("Método adicionar");
        this.pessoas.add(this.pessoa);
        this.pessoa = new Pessoa();
        
        pessoaDAO.inserir(pessoa);

    }
    
    public void exibir(){
        System.out.println("Método exibir");
        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome());
        }
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
    
    
}
