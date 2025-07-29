package br.edu.ifsp.pep.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "produto", uniqueConstraints = {
    @UniqueConstraint(name = "uq_codigo_nome", columnNames = {"codigo", "nome"})
})

public class Produto {
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate data_cadastro;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10)
    private ProdutoStatus status;
    
    @Column(name="valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    public Produto(String nome, LocalDate data_cadastro, ProdutoStatus status, BigDecimal valor) {
        this.nome = nome;
        this.data_cadastro = data_cadastro;
        this.status = status;
        this.valor = valor;
    }

    public Produto() {
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

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public ProdutoStatus getStatus() {
        return status;
    }

    public void setStatus(ProdutoStatus status) {
        this.status = status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}
