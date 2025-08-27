/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Aluno;
import br.edu.ifsp.pep.entidade.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class CursoDAO extends AbstractDAO{
    
    public Curso buscaPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Curso.class, codigo);
    }
    
    public Long contagemDisciplinas(Integer codigo){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Curso.contagemDisciplinas", Curso.class);
        query.setParameter("codigo", codigo);
        return (Long) query.getSingleResult();
    }
}
