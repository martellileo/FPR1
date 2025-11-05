package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CategoriaDAO;
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
    private ProdutoDAO produtoDAO; //mover depois para produtoController

    @Inject()
    private CategoriaDAO categoriaDAO; //mover depois para categoriaController

    public void inserir() {
        //Pessoa
        Pessoa p = new Pessoa();
        p.setNome("Leo");
        p.setDataNascimento(LocalDate.now());
        p.setEmail("l@email.com");
        p.setSalario(new BigDecimal(100000));
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

    public void inserirVarios() {
        // Endereco (mesmo para todos)
        Endereco endereco = new Endereco();
        endereco.setBairro("Jardim Tropical");
        endereco.setLogradouro("Rua Jose Ramos Junior, 27-54");
        endereco.setCidade_estado("Presidente Epitacio - SP");

        // Pessoa 2
        Pessoa p2 = new Pessoa();
        p2.setNome("Ana");
        p2.setDataNascimento(LocalDate.of(1990, 5, 12));
        p2.setEmail("ana@email.com");
        p2.setSalario(new BigDecimal(25000));
        p2.setTipoPessoa(TipoPessoa.Gerente);
        p2.setEndereco(endereco);
        pessoaDAO.inserir(p2);

        // Pessoa 3
        Pessoa p3 = new Pessoa();
        p3.setNome("Carlos");
        p3.setDataNascimento(LocalDate.of(1985, 11, 23));
        p3.setEmail("carlos@email.com");
        p3.setSalario(new BigDecimal(30000));
        p3.setTipoPessoa(TipoPessoa.Gerente);
        p3.setEndereco(endereco);
        pessoaDAO.inserir(p3);

        // Pessoa 4
        Pessoa p4 = new Pessoa();
        p4.setNome("Mariana");
        p4.setDataNascimento(LocalDate.of(1995, 7, 8));
        p4.setEmail("mariana@email.com");
        p4.setSalario(new BigDecimal(1800));
        p4.setTipoPessoa(TipoPessoa.Administrador);
        p4.setEndereco(endereco);
        pessoaDAO.inserir(p4);

        // Pessoa 5
        Pessoa p5 = new Pessoa();
        p5.setNome("João");
        p5.setDataNascimento(LocalDate.of(2000, 3, 17));
        p5.setEmail("joao@email.com");
        p5.setSalario(new BigDecimal(2200));
        p5.setTipoPessoa(TipoPessoa.Administrador);
        p5.setEndereco(endereco);
        pessoaDAO.inserir(p5);

        // Pessoa 6
        Pessoa p6 = new Pessoa();
        p6.setNome("Fernanda");
        p6.setDataNascimento(LocalDate.of(1993, 9, 30));
        p6.setEmail("fernanda@email.com");
        p6.setSalario(new BigDecimal(2700));
        p6.setTipoPessoa(TipoPessoa.Administrador);
        p6.setEndereco(endereco);
        pessoaDAO.inserir(p6);

        // Pessoa 7
        Pessoa p7 = new Pessoa();
        p7.setNome("Rafael");
        p7.setDataNascimento(LocalDate.of(1988, 2, 14));
        p7.setEmail("rafael@email.com");
        p7.setSalario(new BigDecimal(3100));
        p7.setTipoPessoa(TipoPessoa.Administrador);
        p7.setEndereco(endereco);
        pessoaDAO.inserir(p7);

        // Pessoa 8
        Pessoa p8 = new Pessoa();
        p8.setNome("Beatriz");
        p8.setDataNascimento(LocalDate.of(1997, 12, 25));
        p8.setEmail("beatriz@email.com");
        p8.setSalario(new BigDecimal(2300));
        p8.setTipoPessoa(TipoPessoa.Administrador);
        p8.setEndereco(endereco);
        pessoaDAO.inserir(p8);

        // Pessoa 9
        Pessoa p9 = new Pessoa();
        p9.setNome("Lucas");
        p9.setDataNascimento(LocalDate.of(1991, 6, 3));
        p9.setEmail("lucas@email.com");
        p9.setSalario(new BigDecimal(2600));
        p9.setTipoPessoa(TipoPessoa.Professor);
        p9.setEndereco(endereco);
        pessoaDAO.inserir(p9);

        // Pessoa 10
        Pessoa p10 = new Pessoa();
        p10.setNome("Patricia");
        p10.setDataNascimento(LocalDate.of(1986, 10, 19));
        p10.setEmail("patricia@email.com");
        p10.setSalario(new BigDecimal(2900));
        p10.setTipoPessoa(TipoPessoa.Professor);
        p10.setEndereco(endereco);
        pessoaDAO.inserir(p10);
    }

    public void inserirVeiculo() { //mover depois pra VeiculoController
        Veiculo v = new Veiculo();
        v.setNome("Gol");
        v.setTipo(TipoVeiculo.Carro);

        veiculoDAO.inserir(v);
    }

    public void inserirCategoria() { //mover depois para categoriaController
        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        categoriaDAO.inserir(categoria);
    }

    public void inserirProduto() { //mover depois para ProdutoController
        Categoria categoria = (Categoria) categoriaDAO.buscaPorCodigo(1);

        //Produto 1
        Produto produto1 = new Produto();
        produto1.setNome("Produto 1");
        produto1.setPreco(new BigDecimal(10));
        produto1.setQuantidade(100);
        produto1.setCategoria(categoria);

        //Produto 2
        Produto produto2 = new Produto();
        produto2.setNome("Produto 2");
        produto2.setPreco(new BigDecimal(20));
        produto2.setQuantidade(100);
        produto2.setCategoria(categoria);

        produtoDAO.inserir(produto1);
        produtoDAO.inserir(produto2);

    }

    public void alterarCategoria() { //mover depois para categoriaController
        Categoria categoria = categoriaDAO.buscaPorCodigo(1);
        if (categoria != null) {
            System.out.println(categoria.getNome());
            categoria.setNome("Categoria 1 alterada");

            categoriaDAO.alterar(categoria); //teve que mudar pra public?
        } else {
            System.out.println("Categoria não encontrada");
        }

//        ou
//        Categoria categoria = new Categoria();
//        categoria.setCodigo(1);
//        categoria.setNome("Categoria 1 alterada");
//        categoriaDAO.alterar(categoria);
    }

    public void buscarPessoas() {
        List<Pessoa> pessoas = pessoaDAO.buscarTodos();
        System.out.println(pessoas);
    }

    public void buscarPessoaPeloCodigo() {
        Pessoa p = pessoaDAO.buscarPeloCodigo(1);
        if (p == null) {
            System.out.println("pessoa nao encontrada");
        } else {
            System.out.println("==Pessoa==");
            System.out.println(p);
        }
    }

    public void quantidadePessoas() {
        Long qntd = pessoaDAO.quantidadeDePessoas();
        if (qntd != 0) {
            System.out.println("==Quantidade==");
            System.out.println(qntd);
        } else {
            System.out.println("nao encontrado");
        }
    }

    public void maiorSalario() {
        BigDecimal salario = pessoaDAO.maiorSalario();
        System.out.println("==Salario==");
        System.out.println(salario);
    }
    
    public void menorSalario() {
        BigDecimal salario = pessoaDAO.menorSalario();
        System.out.println("==Salario==");
        System.out.println(salario);
    }
    
    public void mediaSalario() {
        Double salario = pessoaDAO.mediaSalario();
        System.out.println("==Media Salario==");
        System.out.println(salario);
    }
    
    public void maisQueCincoMil() {
        List<Pessoa> pessoas = pessoaDAO.maisQueCincoMil();
        System.out.println(pessoas);
    }
    
    public void buscarGerente(){
        List<Pessoa> pessoas = pessoaDAO.buscarGerente();
        System.out.println(pessoas);
    }
    
    public void buscarGerenteMenosCincoMil(){
        List<Pessoa> pessoas = pessoaDAO.buscarGerenteMenosCincoMil();
        System.out.println(pessoas);
    }
    
    public void salarioMedioGerentes(){
        Double salarioMedioGerentes = pessoaDAO.salarioMedioGerentes();
        System.out.println(salarioMedioGerentes);
    }

    //Obter a quantidade de pessoas ok 
    //Obter o maior salario ok
    //obter o menor salario ok
    //obter o salario medio ok
    //obter todas as pessoas que ganham mais de 5k
}
