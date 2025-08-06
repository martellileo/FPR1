/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@IdClass(EmpregadoPK.class)
@Table(name = "empregado")
public class Empregado implements Serializable{
    @Id 
    @Column(name = "nome", length = 50)
    private String nome;
    
    @Id
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "departamento", length = 40)
    private String departamento;

    public Empregado() {
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.dataNascimento);
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
        final Empregado other = (Empregado) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.dataNascimento, other.dataNascimento);
    }
    
}
