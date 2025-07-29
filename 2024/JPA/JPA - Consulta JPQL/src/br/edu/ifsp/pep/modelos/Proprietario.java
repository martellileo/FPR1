package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "nome",  nullable = false)
    private String nome;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @ElementCollection
    @CollectionTable(name = "proprietario_telefone",
            joinColumns = @JoinColumn(name = "proprietario_codigo"))
    @Column(name = "telefone_numero", length = 20, nullable = false)
    private List<String> telefones = new ArrayList<>(); 
    
    public Proprietario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Proprietario() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}
