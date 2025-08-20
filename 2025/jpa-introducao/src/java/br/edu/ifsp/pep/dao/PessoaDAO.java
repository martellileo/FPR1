package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public List<Pessoa> buscarTodos() {
        EntityManager em = getEntityManager();
//        //
//        Query query = em.createQuery("Select p from Pessoa p");

        //NamedQuery
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarTodos", Pessoa.class);
        return query.getResultList();
    }

    public Pessoa buscarPeloCodigo(Integer codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query
                = em.createNamedQuery("Pessoa.buscarPeloCodigo", Pessoa.class);
        query.setParameter("codigo", codigo);
        try {
            return (Pessoa) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Long quantidadeDePessoas() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select count(p) from Pessoa p");
        return (Long) query.getSingleResult();
    }

    public BigDecimal maiorSalario() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select max(p.salario) from Pessoa p");
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal menorSalario() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select min(p.salario) from Pessoa p");
        return (BigDecimal) query.getSingleResult();
    }

    public Double mediaSalario() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select avg(p.salario) from Pessoa p");
        return (Double) query.getSingleResult();
    }

    public List<Pessoa> maisQueCincoMil() {
        EntityManager em = getEntityManager();
        Query query
                = em.createQuery("Select p from Pessoa p where p.salario >= 5000");
        return query.getResultList();
    }

    public List<Pessoa> buscarGerente() {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query
                = em.createNamedQuery("Pessoa.buscarGerente", Pessoa.class);
        return query.getResultList();
    }
    
    public List<Pessoa> buscarGerenteMenosCincoMil() {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query
                = em.createNamedQuery("Pessoa.buscarGerenteMenosCincoMil", Pessoa.class);
        return query.getResultList();
    }
    
    public Double salarioMedioGerentes() {
        EntityManager em = getEntityManager();
        Query query
                = em.createNamedQuery("Pessoa.salarioMedioGerentes", Pessoa.class);
        return (Double) query.getSingleResult();
    }
}
