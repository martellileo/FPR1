package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class VeiculoDAO extends AbstractDAO<Veiculo> {

    public List<Veiculo> buscarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Veiculo> query = em.createNamedQuery("Veiculo.buscarTodos", Veiculo.class);
        return query.getResultList();
    }

    public Veiculo buscarPeloId(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Veiculo.class, id);
    }

    public List<Veiculo> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Veiculo> query = em.createNamedQuery("Veiculo.buscarPeloNome", Veiculo.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}
