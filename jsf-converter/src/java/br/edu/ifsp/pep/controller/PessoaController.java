package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.Cargo;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PessoaController  {

    @Inject
    private PessoaDAO pessoaDAO;
    
    @Inject
    private CargoDAO cargoDAO;


    private List<Pessoa> pessoas;
    private Pessoa pessoa = new Pessoa();
    private int numero = 10;

    public PessoaController() {
        System.out.println("Construtor");
    }
    
    public List<Pessoa> getPessoas() {
        System.out.println("metodo getPessoas");
        if (this.pessoas == null) {
            System.out.println("Acessando banco de dados...");
            this.pessoas = pessoaDAO.buscarTodas();
        }

        return this.pessoas;
    }

    public void excluir(Pessoa pessoa) {
        System.out.println(pessoa);
        
        pessoaDAO.remover(pessoa);
        
        Mensagem.sucesso("Pessoa removida.");
    }

    public void incrementar() {
        this.numero++;
        System.out.println("Numero: " + numero);
    }
    
    public List<Cargo> buscarCargoPeloNome(String query) {
        return cargoDAO.buscarPeloNome(query);
    }

    public String inserir() {

        if (pessoa.getNome().length() < 5) {
            Mensagem.atencao("O Nome deve ter pelo menos 5 caracteres.");
            return null;
        }

        pessoaDAO.inserir(pessoa);
        pessoa = new Pessoa();
        Mensagem.sucesso("Pessoa Cadastrada.");
        
        return "/pessoa/lista";
    }

    public void exibir() {
        System.out.println("Metodo exibir.");
        System.out.println(pessoa);
        System.out.println("Numero: " + numero);
//        System.out.println("Nome: " + nome);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
