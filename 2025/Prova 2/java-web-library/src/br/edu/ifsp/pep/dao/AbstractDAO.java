package br.edu.ifsp.pep.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class AbstractDAO<T> {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void inserir(T entity) {
        em.persist(entity);
    }
    
    public void alterar(T entity) {
        //Se a chave primaria da entity existir, altera o objeto
        //Se nao existir, cria.
        em.merge(entity);
    }

    public void remover(T entity) {
        em.remove(em.merge(entity));
    }

}
