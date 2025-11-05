/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Disciplina;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DisciplinaDAO extends AbstractDAO{
    public Disciplina buscaPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Disciplina.class, codigo);
    }
    
    public List buscarDisciplinasAlunoMatriculado(Integer codigo){
        EntityManager em = getEntityManager();
        Query query
                = em.createNamedQuery("Disciplina.buscarDisciplinasAlunoMatriculado", Disciplina.class);
        query.setParameter("codigo", codigo);
        
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
