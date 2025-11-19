package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Lancamento;
import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LancamentoDAO extends AbstractDAO<Lancamento>{
    public List<Lancamento> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Lancamento> query = em.createNamedQuery("Lancamento.buscarTodos", Lancamento.class);

        return query.getResultList();
    }
}
