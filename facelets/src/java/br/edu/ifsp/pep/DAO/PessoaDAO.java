/*
 */

package br.edu.ifsp.pep.DAO;

import br.edu.ifsp.pep.dao.AbstractDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {
    
    public List<Pessoa> buscarTodas(){
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarTodas", Pessoa.class);
        
        return query.getResultList();
    }
}
