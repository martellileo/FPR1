package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Alocado;
import br.edu.ifsp.pep.entidade.Alocado;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AlocadoDAO extends AbstractDAO<Alocado>{
    
    public List<Alocado> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Alocado> query = em.createNamedQuery("Alocado.buscarTodos", Alocado.class);
        return query.getResultList();
    }
    
    public Alocado buscarPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Alocado.class, codigo);
    }
}
