package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Produto")
@NamedQueries(value ={
    @NamedQuery(name = "Produto.buscarTodos",
               query = "from Produto p"),
    @NamedQuery(name = "Produto.buscarPeloNome",
               query = "select p from Produto p where p.nome like :nome")
})
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "desconto")
    private Double desconto;
    
    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "preco", precision = 8, scale = 2)
    private BigDecimal preco;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @ManyToOne()
    @JoinColumn(name = "categoria_id", nullable = false)    
    private Categoria categoria;

    public Produto() {
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", desconto=" + desconto + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + ", categoria=" + categoria + '}';
    }

    
}
