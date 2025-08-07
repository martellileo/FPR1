package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "itens")
public class Itens implements Serializable {
    @EmbeddedId
    private ItensId itensId;
    
    @ManyToOne
    @MapsId("vendaCodigo")
    @JoinColumn(name = "venda_codigo", referencedColumnName = "codigo")
    private Venda venda;

    @ManyToOne
    @MapsId("produtoCodigo")
    @JoinColumn(name = "produto_codigo", referencedColumnName = "codigo")
    private Produto produto;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "preco", precision = 6, scale = 2)
    private BigDecimal preco;

    public ItensId getItensId() {
        return itensId;
    }

    public void setItensId(ItensId itensId) {
        this.itensId = itensId;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.itensId);
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
        final Itens other = (Itens) obj;
        return Objects.equals(this.itensId, other.itensId);
    }
    
    
}
