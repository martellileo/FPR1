/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.entity.Veiculo;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class VeiculoController implements Serializable{
    
    @Inject
    private VeiculoDAO veiculoDAO;
    
    private List<Veiculo> veiculos = new ArrayList<>();
    private Veiculo veiculoSelecionado;

    private Veiculo veiculo = new Veiculo();

    public VeiculoController() {
        System.out.println("Construtor Veiculo Controller");
    }
    
    public void exibir() {
        System.out.println("Método exibir");
        System.out.println(getVeiculoSelecionado().getPlaca());
    }
    
    public void adicionar(){
        System.out.println("Metodo adicionar");
        this.veiculos.add(this.veiculo);
        
        veiculoDAO.inserir(veiculo);
        
        this.veiculo = new Veiculo();
        
        Mensagem.sucesso("Pessoa Cadastrada", "Sucesso");
        
    }
    
    public void remover() {
        System.out.println(veiculoSelecionado.getNome());
        veiculoDAO.remover(veiculoSelecionado, Pessoa.class);

        veiculos = null;

        Mensagem.sucesso("Pessoa excluida", "Sucesso");
    }

    public VeiculoDAO getVeiculoDAO() {
        return veiculoDAO;
    }

    public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
     
    
    
}
