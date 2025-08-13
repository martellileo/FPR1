package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import br.edu.ifsp.pep.entidade.Endereco;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import br.edu.ifsp.pep.entidade.TipoVeiculo;
import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {
    
    @Inject()
    private PessoaDAO pessoaDAO;
    
    @Inject()
    private VeiculoDAO veiculoDAO; //mover depois para VeiculoController
    
    @Inject()
    private ProdutoDAO produtoDAO;
    
    public void inserir() {
        //Pessoa
        Pessoa p = new Pessoa();
        p.setNome("Leo");
        p.setDataNascimento(LocalDate.now());
        p.setEmail("l@email.com");
        p.setSalario(new BigDecimal(1000));
        p.setTipoPessoa(TipoPessoa.Administrador);
        
    
        //Endereco
        Endereco e = new Endereco();
        e.setBairro("Jardim Tropical");
        e.setLogradouro("Rua Jose Ramos Junior, 27-54");
        e.setCidade_estado("Presidente Epitacio - SP");
        
        p.setEndereco(e);
        
        
        //Veiculo
        Veiculo v1 = new Veiculo();
        v1.setNome("Palio");
        v1.setTipo(TipoVeiculo.Carro);
        
        Veiculo v2 = new Veiculo();
        v2.setNome("Zentorno");
        v2.setTipo(TipoVeiculo.Carro);
        
        List<Veiculo> veiculos = new ArrayList();
        veiculos.add(v1);
        veiculos.add(v2);
        
        p.setVeiculos(veiculos);
        
        
        pessoaDAO.inserir(p);
    }    
    
    public void inserirVeiculo(){ //mover depois pra VeiculoController
        Veiculo v = new Veiculo();
        v.setNome("Gol");
        v.setTipo(TipoVeiculo.Carro);
        
        veiculoDAO.inserir(v);
    }
    
    public void inserirProduto(){
        Produto produto1 = new Produto();
        
        produto1.setNome("Pren d 10");
        produto1.setPreco(new BigDecimal(10));
        produto1.setQuantidade(100);
        
        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        
        produto1.setCategoria(categoria);
        
        produtoDAO.inserir(produto1);
        
        
        Produto produto2 = new Produto();
        produto2.setNome("Pren d 20");
        produto2.setPreco(new BigDecimal(20));
        produto2.setQuantidade(100);
        
        produto2.setCategoria(categoria);
        
        produtoDAO.inserir(produto2);
        
    }
}
