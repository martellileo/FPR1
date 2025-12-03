package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "alocado")
@IdClass(AlocadoPK.class)
@NamedQueries(value = {
    @NamedQuery(name = "Alocado.buscarTodos", query = "FROM Alocado a"),
})
public class Alocado implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "desenvolvedor")
    private Desenvolvedor desenvolvedor;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "projeto")
    private Projeto projeto;
    
    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;
    
    @Column(name = "horas_semanais", nullable = false)
    private Integer horas;

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.desenvolvedor);
        hash = 43 * hash + Objects.hashCode(this.projeto);
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
        final Alocado other = (Alocado) obj;
        if (!Objects.equals(this.desenvolvedor, other.desenvolvedor)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

    @Override
    public String toString() {
        return "Alocado{" + "desenvolvedor=" + desenvolvedor + ", projeto=" + projeto + ", valor=" + valor + ", horas=" + horas + '}';
    }
    
}
