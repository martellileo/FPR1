package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.DesenvolvedorDAO;
import br.edu.ifsp.pep.entidade.Desenvolvedor;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DesenvolvedorController implements Serializable {

    @Inject
    private DesenvolvedorDAO desenvolvedorDAO;
    
    private Desenvolvedor desenvolvedorEscolhido;

    public DesenvolvedorController() {
        System.out.println("construtor desenvolvedor controller");
    }
      
    public List<Desenvolvedor> buscarTodosDesenvolvedores() {
        return desenvolvedorDAO.buscarTodos();
    }

    public Desenvolvedor getDesenvolvedorEscolhido() {
        return desenvolvedorEscolhido;
    }

    public void setDesenvolvedorEscolhido(Desenvolvedor desenvolvedorEscolhido) {
        this.desenvolvedorEscolhido = desenvolvedorEscolhido;
    }
    
    
}
