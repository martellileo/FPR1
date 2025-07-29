package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.modelo.Venda;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cesar
 */

@Named
@ViewScoped
public class VendaController implements Serializable{
    
    @Inject
    private VendaDAO vendaDAO;
    
    private List<Venda> vendas;
    
    public List<Venda> getVendas(){
        if(vendas == null){
            System.out.println("buscando itens no db");
            vendas = vendaDAO.findAll();
        }
        return vendas;
    }
    
    public void vendasList(){
        this.vendas = vendaDAO.findAll();
    }
}
