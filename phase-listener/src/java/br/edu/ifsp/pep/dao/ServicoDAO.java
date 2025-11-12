package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Servico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class ServicoDAO extends AbstractDAO<Servico> {

    public List<Servico> buscarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Servico> query = em.createNamedQuery("Servico.buscarTodos", Servico.class);
        return query.getResultList();
    }

    public Servico buscarPeloId(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Servico.class, id);
    }

    public List<Servico> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Servico> query = em.createNamedQuery("Servico.buscarPeloNome", Servico.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}
