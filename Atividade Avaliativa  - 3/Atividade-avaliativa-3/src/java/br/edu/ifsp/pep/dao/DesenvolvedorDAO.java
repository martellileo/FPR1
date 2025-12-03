
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Desenvolvedor;
import br.edu.ifsp.pep.entidade.Desenvolvedor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class DesenvolvedorDAO extends AbstractDAO<Desenvolvedor>{
    
    public List<Desenvolvedor> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Desenvolvedor> query = em.createNamedQuery("Desenvolvedor.buscarTodos", Desenvolvedor.class);
        return query.getResultList();
    }
    
    public List<Desenvolvedor> buscarPorNome(String nome){
        EntityManager em = getEntityManager();
        TypedQuery<Desenvolvedor> query = em.createNamedQuery("Desenvolvedor.buscarPorNome", Desenvolvedor.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public Desenvolvedor buscarPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Desenvolvedor.class, codigo);
    }
    
    public void alterarEstado(Integer codigo){
        EntityManager em = getEntityManager();
        TypedQuery<Desenvolvedor> query = em.createNamedQuery("Desenvolvedor.alterarEstado", Desenvolvedor.class);
        query.setParameter("codigo", codigo);
    }
}
