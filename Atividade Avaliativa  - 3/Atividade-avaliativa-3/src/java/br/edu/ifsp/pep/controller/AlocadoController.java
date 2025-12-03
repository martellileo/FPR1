package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.AlocadoDAO;
import br.edu.ifsp.pep.dao.DesenvolvedorDAO;
import br.edu.ifsp.pep.dao.ProjetoDAO;
import br.edu.ifsp.pep.entidade.Alocado;
import br.edu.ifsp.pep.entidade.Desenvolvedor;
import br.edu.ifsp.pep.entidade.Projeto;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class AlocadoController implements Serializable {

    private Projeto p = null;
    private Desenvolvedor d = null;

    private List<Alocado> alocados = null;

    @Inject
    private AlocadoDAO alocadoDAO;
    
    @Inject
    private DesenvolvedorDAO desenvolvedorDAO;

    @Inject
    private ProjetoController projetoController;

    @Inject
    private DesenvolvedorController desenvolvedorController;

    private Integer quantidadeHoras;

    private BigDecimal valor;

    public AlocadoController() {

    }

    public void adicionar() throws Exception {
        p = projetoController.getProjetoEscolhido();
        d = desenvolvedorController.getDesenvolvedorEscolhido();

        if (d.getEstado().equals("Alocado")) {
            Mensagem.erro("Desenvolvedor ja alocado a um projeto");
        } else {
            Integer codigoDev = p.getCodigo();
            
            Alocado a = new Alocado();
            a.setHoras(quantidadeHoras);
            a.setValor(valor);
            a.setDesenvolvedor(d);
            a.setProjeto(p);
            
            alocadoDAO.inserir(a);
            Mensagem.sucesso("Desenvolvedor alocado com sucesso");
        }
    }
    
    public void excluir(Alocado alocado) {
        
        alocadoDAO.remover(alocado);
        
        Mensagem.sucesso("Alocaçao removida.");
    }

    public List<Alocado> getAlocados() {

        if (this.alocados == null) {
            this.alocados = alocadoDAO.buscarTodos();
        }

        return this.alocados;
    }

    public void atualizar() {
        alocados = null;
    }

    public void setAlocados(List<Alocado> alocados) {
        this.alocados = alocados;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
