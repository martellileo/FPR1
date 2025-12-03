package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlocadoPK implements Serializable {
    @Column(name = "id_desenvolvedor", nullable = false)
    private Integer desenvolvedor;
    
    @Column(name = "id_projeto", nullable = false)
    private Integer projeto;

    public Integer getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Integer desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Integer getProjeto() {
        return projeto;
    }

    public void setProjeto(Integer projeto) {
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.desenvolvedor);
        hash = 71 * hash + Objects.hashCode(this.projeto);
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
        final AlocadoPK other = (AlocadoPK) obj;
        if (!Objects.equals(this.desenvolvedor, other.desenvolvedor)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

    @Override
    public String toString() {
        return "AlocadoPK{" + "desenvolvedor=" + desenvolvedor + ", projeto=" + projeto + '}';
    }
}
