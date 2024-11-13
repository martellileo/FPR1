package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.modelo.ItemVenda;
import br.edu.ifsp.pep.modelo.Produto;
import br.edu.ifsp.pep.modelo.Venda;
import br.edu.ifsp.pep.util.JsfUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.model.SelectItemGroup;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cesar
 */
@Named
@ViewScoped
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoDAO produtoDAO;
    
    @Inject
    private VendaDAO vendaDAO;

    private Produto produtoSelecionado;

    private Integer quantidade;

    private List<ItemVenda> itens = new ArrayList<>();

    private Venda venda = new Venda();

    public void adicionar() {

        ItemVenda iv = null;

        int pos = itens.indexOf(new ItemVenda(produtoSelecionado, venda));
        if (pos > -1) {
            iv = itens.get(pos);
            iv.setQuantidade(iv.getQuantidade() + quantidade);
        }

//        if (itens.contains(new ItemVenda(produtoSelecionado, venda))) {
//            iv = itens.get(itens.indexOf(new ItemVenda(produtoSelecionado, venda)));
//            iv.setQuantidade(iv.getQuantidade() + quantidade);
//        }
        if (iv == null) {
            iv = new ItemVenda();
            iv.setPreco(produtoSelecionado.getPreco());
            iv.setProduto(produtoSelecionado);
            iv.setQuantidade(quantidade);
            iv.setVenda(venda);

            itens.add(iv);
        }
        JsfUtil.addSuccessMessage("Produto Adicionado");
    }
    
    public double getTotal(){
        double total = 0;
        for (ItemVenda iv : itens) {
            total += iv.getPreco() * iv.getQuantidade();
        }
        return total;
    }
    
    private void inicializar(){
        venda = new Venda();
        itens = new ArrayList<>();
        produtoSelecionado = null;
        quantidade = null;
    }
    
    public void finalizar(){
        venda.setItemVendaList(itens);
        venda.setData(new Date());
        
        vendaDAO.create(venda);
        
        JsfUtil.addSuccessMessage("Venda criada.");
        inicializar();
    }

    public List<Produto> buscarTodos() {
        return produtoDAO.findAll();
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

}
