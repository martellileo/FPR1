package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Projeto;
import br.edu.ifsp.pep.entidade.Projeto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProjetoDAO extends AbstractDAO<Projeto>{
    
    public List<Projeto> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Projeto> query = em.createNamedQuery("Projeto.buscarTodos", Projeto.class);
        return query.getResultList();
    }
    
    public List<Projeto> buscarPorNome(String nome){
        EntityManager em = getEntityManager();
        TypedQuery<Projeto> query = em.createNamedQuery("Projeto.buscarPorNome", Projeto.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public Projeto buscarPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Projeto.class, codigo);
    }
}
