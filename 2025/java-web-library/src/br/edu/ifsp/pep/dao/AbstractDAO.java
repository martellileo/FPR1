package br.edu.ifsp.pep.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class AbstractDAO<T> {
    @PersistenceContext(name = "conexaoPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public void inserir(T entity) {
        em.persist(entity);
    }
    
    public void alterar(T entity){
        em.merge(entity);
    }
    
    protected void remover(T entity){
        em.remove(em.merge(entity));
    }
}
