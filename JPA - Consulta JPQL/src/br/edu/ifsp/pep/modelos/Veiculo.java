package br.edu.ifsp.pep.modelos;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "veiculo")
@NamedQueries(value = {
    @NamedQuery(name = "Veiculo.buscarPeloAno", query = "SELECT v FROM Veiculo v WHERE v.ano = 2000"),
    @NamedQuery(name = "Veiculo.buscarPelaPlaca", query = "FROM Veiculo v WHERE v.codigo.placa = :placa"),
    @NamedQuery(name = "Veiculo.buscarPelaPlacaECidade", query = "FROM Veiculo v WHERE v.codigo.placa = :placa AND v.codigo.cidade = :cidade")
})
public class Veiculo implements Serializable {
    @EmbeddedId
    private VeiculoId codigo;
    
    @Column(name = "ano", nullable = false)
    private int ano;
    
    @Column(name = "fabricante", length = 60, nullable = false)
    private String fabricante;
    
    public Veiculo() {
    }

    public Veiculo(VeiculoId codigo, int ano, String fabricante) {
        this.codigo = codigo;
        this.ano = ano;
        this.fabricante = fabricante;
    }
    
    public VeiculoId getCodigo() {
        return codigo;
    }

    public void setCodigo(VeiculoId codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
}
