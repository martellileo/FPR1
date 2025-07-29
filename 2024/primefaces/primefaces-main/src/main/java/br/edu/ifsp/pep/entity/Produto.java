/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

/**
 *
 * @author aluno
 */
public class Produto {
    private Integer codigo;
    
    private Double valor;
    
    private String descricao;

    public Produto() {
    }

    public Produto(Integer codigo, String descricao, Double valor) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
    
    
}
