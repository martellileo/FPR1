package br.edu.ifsp.pep.entidade;

import java.io.Serializable;
import java.util.Objects;

public class ManutencaoPK implements Serializable {

    private Integer veiculo;
    
    private Integer servico;

    public Integer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Integer veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.veiculo);
        hash = 37 * hash + Objects.hashCode(this.servico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ManutencaoPK other = (ManutencaoPK) obj;
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        return Objects.equals(this.servico, other.servico);
    }

  
    
}
