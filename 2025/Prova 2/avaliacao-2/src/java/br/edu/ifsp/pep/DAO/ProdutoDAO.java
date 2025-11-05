package br.edu.ifsp.pep.DAO;

import br.edu.ifsp.pep.dao.AbstractDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
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
    
    public List<Produto> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarPeloNome", Produto.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public Categoria buscarPeloId(Integer id){
        EntityManager em = getEntityManager();
        return em.find(Categoria.class, id);
    }
}
