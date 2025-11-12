package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ManutencaoDAO;
import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Manutencao;
import br.edu.ifsp.pep.entidade.Servico;
import br.edu.ifsp.pep.entidade.Veiculo;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class ManutencaoController {

    @Inject
    private ManutencaoDAO manutencaoDAO;

    @Inject
    private VeiculoDAO veiculoDAO;

    @Inject
    private ServicoDAO servicoDAO;

    private Manutencao manutencao = new Manutencao();
    private List<Manutencao> manutencoes;

    public List<Veiculo> buscarVeiculoPeloNome(String query) {
        return veiculoDAO.buscarPeloNome(query);
    }

    public List<Servico> buscarServicoPeloNome(String query) {
        return servicoDAO.buscarPeloNome(query);
    }

    public String inserir() {
        manutencao.setData(LocalDate.now());
        manutencaoDAO.inserir(manutencao);
        manutencao = new Manutencao();
        Mensagem.sucesso("Manutencao Registrada.");

        return "/manutencao/lista";
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public List<Manutencao> getManutencoes() {
        if (this.manutencoes == null) {
            this.manutencoes = manutencaoDAO.buscarTodas();
        }

        return manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

}
