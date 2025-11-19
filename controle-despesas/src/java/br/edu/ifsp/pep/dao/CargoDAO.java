package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Cargo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class CargoDAO extends AbstractDAO<Cargo> {

    public List<Cargo> buscarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Cargo> query = em.createNamedQuery("Cargo.buscarTodos", Cargo.class);
        return query.getResultList();
    }

    public Cargo buscarPeloId(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Cargo.class, id);
    }

    public List<Cargo> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Cargo> query = em.createNamedQuery("Cargo.buscarPeloNome", Cargo.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}
