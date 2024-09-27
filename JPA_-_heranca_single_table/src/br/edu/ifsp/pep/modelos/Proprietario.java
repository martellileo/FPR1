package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proprietario")
@DiscriminatorColumn(name = "tipo", length = 15,
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PESSOA")
public class Proprietario implements Serializable {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Long codigo;
    
    @Column(name="nome")
    private String nome;
    
    @OneToMany(mappedBy = "proprietario")
    private List<Veiculo> veiculos;

    public Proprietario() {
    }

    public Proprietario(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Proprietario{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    
}
