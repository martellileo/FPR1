package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.Venda;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
//@RequestScoped
//@ViewScoped //Enquanto nao trocar de pagina ou atualizar a pagina
@SessionScoped
public class VendaController implements Serializable {
    
    @Inject
    private VendaDAO vendaDAO;
    
    @Inject
    private ProdutoDAO produtoDAO;
   
    private Produto produtoSelecionado; //combobox - select
    private int quantidade;
    
    private Venda venda = new Venda();
    private List<ItemVenda> itensVenda = new ArrayList<>();
    

    public VendaController() {
        System.out.println("construtor venda controller");
    }
    
    public void adicionar() {
        System.out.println("...." + produtoSelecionado);
        
        ItemVenda item = new ItemVenda();
        item.setProduto(produtoSelecionado);
        item.setVenda(venda);
        item.setPreco(produtoSelecionado.getPreco());
        item.setQuantidade(quantidade);
        
        itensVenda.add(item);
        
    }
    
    public String finalizar() throws Exception {
       
        venda.setData(LocalDateTime.now());
        venda.setItens(itensVenda);
        
        vendaDAO.inserir(venda);
        Mensagem.sucesso("Venda finalizada.");
        
        //Iniciar nova venda
        venda = new Venda();
        itensVenda = new ArrayList<>();
        produtoSelecionado = null;
        quantidade = 0;
        
        return "/venda/criar";
    }
    
    public double getValorTotal() {
        double valorTotal = 0;
        for (ItemVenda itemVenda : itensVenda) {
            valorTotal += itemVenda.getPreco().doubleValue() * itemVenda.getQuantidade();
        }
        return valorTotal;
    }
    
    public List<Produto> buscarTodosProdutos() {
        return produtoDAO.buscarTodos();
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }
    
    
}
