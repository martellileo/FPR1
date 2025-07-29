package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "comissionado")
public class Comissionado extends Assalariado{
    @Column(name = "comissao")
    private double comissao;

    public Comissionado() {
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public Comissionado(double comissao, double salarioFixo, String nome, String login, String senha) {
        super(salarioFixo, nome, login, senha);
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return super.toString() + "comissao=" + comissao;
    }
    
}
