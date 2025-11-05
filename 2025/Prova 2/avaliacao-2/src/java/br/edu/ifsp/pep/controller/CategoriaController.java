package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.DAO.CategoriaDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named(value = "categoriaController")
@RequestScoped
public class CategoriaController {
    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;
    
    private Categoria filtro;
     
    @Inject()
    private CategoriaDAO categoriaDAO;
    
    @Inject() 
    private ProdutoController produtoController;
    
    public List<Categoria> buscarPeloNome(String nome){
        return categoriaDAO.buscarPeloNome(nome);
    }
    
    public void aplicarFiltro() {
        System.out.println("Filtro selecionado: " + (filtro != null ? filtro.getNome() : "Nenhum"));
        
        // Força o ProdutoController a recarregar a lista na próxima vez
        // que 'getProdutos()' for chamado.
        produtoController.setProdutos(null);
    }

    public CategoriaController() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        if(categorias == null){
            categorias = categoriaDAO.buscarTodos();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getFiltro() {
        return filtro;
    }

    public void setFiltro(Categoria filtro) {
        this.filtro = filtro;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
    
    
}
