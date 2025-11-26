package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProdutoDAO extends AbstractDAO<Produto>{
   
    public List<Produto> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarTodos", Produto.class);
        return query.getResultList();
    }
    
    public List<Produto> buscarPorNome(String nome){
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarPorNome", Produto.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public Produto buscarPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Produto.class, codigo);
    }
}
