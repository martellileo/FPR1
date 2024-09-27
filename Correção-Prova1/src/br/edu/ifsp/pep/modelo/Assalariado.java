/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "assalariado")
@NamedQueries({
    @NamedQuery(name = "Assalariado.reajustarSalario",
            query = "UPDATE Assalariado a SET a.salarioFixo = a.salarioFixo + (a.salarioFixo * :porcentagem)/100"),
    @NamedQuery(name = "Assalariado.findAll",
            query = "FROM Assalariado a")
})
public class Assalariado extends Funcionario{   
    @Column(name = "salario_fixo", nullable = false)
    private double salarioFixo;

    public Assalariado() {
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    @Override
    public String toString() {
        return super.toString() + " salarioFixo=" + salarioFixo;
    }

    public Assalariado(double salarioFixo, String nome, String login, String senha) {
        super(nome, login, senha);
        this.salarioFixo = salarioFixo;
    }
    
    
}
