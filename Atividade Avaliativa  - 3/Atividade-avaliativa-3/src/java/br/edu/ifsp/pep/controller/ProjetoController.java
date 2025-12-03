package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProjetoDAO;
import br.edu.ifsp.pep.entidade.Projeto;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProjetoController implements Serializable {
  
    @Inject
    private ProjetoDAO projetoDAO;

    private Projeto projetoEscolhido;
    
    public ProjetoController() {
    
    }  
    
    public List<Projeto> buscarTodosProjetos() {
        return projetoDAO.buscarTodos();
    }

    public Projeto getProjetoEscolhido() {
        return projetoEscolhido;
    }

    public void setProjetoEscolhido(Projeto projetoEscolhido) {
        this.projetoEscolhido = projetoEscolhido;
    }   
}
