/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@NamedQueries(value = {
    @NamedQuery(name = "Pessoa.buscarTodas", query = "FROM Pessoa p")
})
public class Pessoa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "nome", length = 50)
    private String nome;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "salario")
    private double salario;
    
    @ManyToOne
    @JoinColumn(name = "cargo_codigo")
    private Cargo cargo;

    public int getCodigo() {
        return codigo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Pessoa() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigo;
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
        final Pessoa other = (Pessoa) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", salario=" + salario + '}';
    }
    
    
}
