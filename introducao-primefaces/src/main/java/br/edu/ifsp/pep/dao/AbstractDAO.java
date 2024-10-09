package br.edu.ifsp.pep.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class AbstractDAO<T> {
    
    @PersistenceContext(unitName = "conexaoPU")
    protected EntityManager em;
    
    public void inserir(T entity){
        em.persist(entity);
    }
    
    public void remover(T entity, Object pk){
//        em.remove(em.merge(entity));
        Object obj = em.find(entity.getClass(), pk);
        
        if(obj != null){
            em.remove(obj);
        }
    }
    
    public void alterar(T entity){
        em.merge(entity);
    }
}
