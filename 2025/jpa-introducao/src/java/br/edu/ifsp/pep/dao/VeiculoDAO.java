/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class VeiculoDAO {
    @PersistenceContext(name = "conexaoPU")
    private EntityManager em;

    public VeiculoDAO() {
        System.out.println("VeiculoDAO");
    }

    public void inserir(Veiculo v) {
        em.persist(v);
    }
}
