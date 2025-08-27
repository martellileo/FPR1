/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Aluno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AlunoDAO extends AbstractDAO{
    // pesquisas
    
    public List<Aluno> buscarAlunosCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        TypedQuery<Aluno> query
                = em.createNamedQuery("Aluno.buscarAlunosCodigo", Aluno.class);
        query.setParameter("codigo", codigo);
        
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
}
