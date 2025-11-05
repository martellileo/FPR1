package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItensId implements Serializable{
    @Column(name = "produto_codigo", insertable = false, updatable = false)
    private Integer produtoCodigo;
     
    @Column(name = "venda_codigo", insertable = false, updatable = false)
    private Integer vendaCodigo;

    public int getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(int produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public int getVendaCodigo() {
        return vendaCodigo;
    }

    public void setVendaCodigo(int vendaCodigo) {
        this.vendaCodigo = vendaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.produtoCodigo;
        hash = 37 * hash + this.vendaCodigo;
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
        final ItensId other = (ItensId) obj;
        if (this.produtoCodigo != other.produtoCodigo) {
            return false;
        }
        return this.vendaCodigo == other.vendaCodigo;
    }
    
    
}
