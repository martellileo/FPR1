/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.entity.Produto;
import br.edu.ifsp.pep.util.Relatorio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class ProdutoController {   
    
    public StreamedContent gerarRelatorioProdutos() throws FileNotFoundException{
        
        List<Produto> dados = gerarListaProdutos();
        
        File file = new File("br/edu/ifsp/pep/relatorioproduto.jrxml");
        
        InputStream is = new FileInputStream(file);
        
        return Relatorio.gerar(is, null, dados);
    }
    
    private List<Produto> gerarListaProdutos() {
        List<Produto> produtos = new ArrayList<>();
        for(int i = 1; i < 30; i++){
            produtos.add(new Produto(i, "Produto" + i, Math.random()));
        }
        return produtos;
    }
}
