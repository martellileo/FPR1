/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProdutoDAO {
    @PersistenceContext(name = "conexaoPU")
    private EntityManager em;

    public ProdutoDAO() {
        System.out.println("ProdutoDAO");
    }

    public void inserir(Produto p) {
        em.persist(p);
    }
}
