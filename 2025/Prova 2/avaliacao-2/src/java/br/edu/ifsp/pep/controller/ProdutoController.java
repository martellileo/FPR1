package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.DAO.ProdutoDAO;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ProdutoController implements Serializable {

    private Produto produto = new Produto();
    private List<Produto> produtos;

    @Inject()
    private ProdutoDAO produtoDAO;

    public void adicionarProduto() {

        if (produto.getNome().length() < 5) {;
            Mensagem.atencao("Nome do produto deve conter mais que quatro caracteres");
        } else {
            produto.setQuantidade(10);
            produtoDAO.inserir(produto);
            Mensagem.sucesso("Produto cadastrado no banco de dados");
            produto = new Produto();
        }
    }

    public void excluir(Produto produto) {
        produtoDAO.remover(produto);
        Mensagem.sucesso("Produto removido do banco de dados");
        produtos = null;
    }
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = produtoDAO.buscarTodos();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public String toString() {
        return "ProdutoController{" + "produto=" + produto + ", produtos=" + produtos + ", produtoDAO=" + produtoDAO + '}';
    }

    public ProdutoController() {
    }

}
