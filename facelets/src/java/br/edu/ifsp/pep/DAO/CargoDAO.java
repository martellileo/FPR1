package br.edu.ifsp.pep.DAO;

import br.edu.ifsp.pep.dao.AbstractDAO;
import br.edu.ifsp.pep.entidade.Cargo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CargoDAO extends AbstractDAO<Cargo> {
    
    public List<Cargo> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Cargo> query = em.createNamedQuery("Cargo.buscarTodos", Cargo.class);
        
        return query.getResultList();
    }
}
