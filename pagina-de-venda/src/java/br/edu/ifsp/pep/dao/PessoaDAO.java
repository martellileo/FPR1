
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa>{
    
    public void inserir(Pessoa pessoa) {
        EntityManager em = getEntityManager();
        em.persist(pessoa);
    }
    
}
