/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entidade;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EmpregadoPK implements Serializable{
    
    private String nome;
    
    private LocalDate dataNascimento;

    public EmpregadoPK() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.dataNascimento);
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
        final EmpregadoPK other = (EmpregadoPK) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.dataNascimento, other.dataNascimento);
    }
    
}
