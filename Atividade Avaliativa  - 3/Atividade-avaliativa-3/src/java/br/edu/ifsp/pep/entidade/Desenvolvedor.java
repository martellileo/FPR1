package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "desenvolvedor")
@NamedQueries(value = {
    @NamedQuery(name = "Desenvolvedor.buscarTodos", query = "FROM Desenvolvedor d"),
    @NamedQuery(name = "Desenvolvedor.buscarPorNome", query = "FROM Desenvolvedor d WHERE d.nome = :nome")
})
public class Desenvolvedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" + "codigo=" + codigo + ", nome=" + nome + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Desenvolvedor other = (Desenvolvedor) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    
}
