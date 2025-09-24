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
@Table(name = "cargo")
@NamedQueries(value = {
    @NamedQuery(name = "Cargo.buscarTodos", query = "FROM Cargo c")
})
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    public Cargo() {
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
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
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
        final Cargo other = (Cargo) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Cargo{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }

}
