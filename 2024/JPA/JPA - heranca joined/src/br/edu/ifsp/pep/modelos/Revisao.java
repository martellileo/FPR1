package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "revisao")
public class Revisao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "data", nullable = false)
    private Date data;
    
    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @ManyToOne
    @JoinColumns(value = {
        @JoinColumn(name = "veiculo_placa",
                referencedColumnName = "placa",
                nullable = false),
        @JoinColumn(name = "veiculo_cidade",
                referencedColumnName = "cidade",
                nullable = false)
    })
    private Veiculo veiculo;

    public Revisao() {
    }

    public Revisao(Date data, Double valor, String descricao, Veiculo veiculo) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.veiculo = veiculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
}
