package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.LancamentoDAO;
import br.edu.ifsp.pep.entidade.Lancamento;
import br.edu.ifsp.pep.entidade.TipoLancamento;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class LancamentoController implements Serializable {

    @Inject
    private LancamentoDAO lancamentoDAO;

    private List<Lancamento> lancamentos;
    private Lancamento lancamento = new Lancamento();

    public LancamentoController() {
        System.out.println("Construtor");
    }

    public List<Lancamento> getLancamentos() {
        System.out.println("metodo getLancamentos");
        if (this.lancamentos == null) {
            System.out.println("Acessando banco de dados...");
            this.lancamentos = lancamentoDAO.buscarTodos();
        }

        return this.lancamentos;
    }

    public void excluir(Lancamento lancamento) {
        System.out.println(lancamento);

        lancamentoDAO.remover(lancamento);

        Mensagem.sucesso("Lancamento removida.");
    }

    public String inserir() {

        lancamentoDAO.inserir(lancamento);
        lancamento = new Lancamento();
        Mensagem.sucesso("Lancamento Cadastrado.");

        return "/lancamento/lista";
    }
    
    public TipoLancamento[] getTiposLancamento() {
        return TipoLancamento.values();
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

}
