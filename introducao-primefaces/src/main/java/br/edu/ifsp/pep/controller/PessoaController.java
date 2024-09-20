package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
// @RequestScoped -> não precisa implementar serializable
@ViewScoped // escopo do tipo view
public class PessoaController implements Serializable {

    private List<Pessoa> pessoas = new ArrayList<>();
    
    private Pessoa pessoa = new Pessoa();
    
    public PessoaController() {
        System.out.println("Construtor Pessoa Controller");
    }
    
    public void adicionar(){
        System.out.println("Método adicionar");
        this.pessoas.add(this.pessoa);
        this.pessoa = new Pessoa();

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
