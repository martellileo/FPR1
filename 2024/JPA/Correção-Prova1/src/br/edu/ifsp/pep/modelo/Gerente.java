package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Funcionario{
    @Column(name = "percentual", nullable = false)
    private double percentual;
    
    @Column(name = "valor_vendas", nullable = false)
    private double valorVendas;

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public Gerente() {
    }

    public Gerente(double percentual, double valorVendas, String nome, String login, String senha) {
        super(nome, login, senha);
        this.percentual = percentual;
        this.valorVendas = valorVendas;
    }

    @Override
    public String toString() {
        return super.toString() + " percentual=" + percentual + ", valorVendas=" + valorVendas;
    }
    
}
