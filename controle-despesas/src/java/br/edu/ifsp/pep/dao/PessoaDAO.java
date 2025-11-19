package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public List<Pessoa> buscarTodas() {

        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarTodas", Pessoa.class);

        return query.getResultList();

    }

    public Pessoa realizarLogin(String login, String password) {
        
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.realizarLogin", Pessoa.class);
        query.setParameter("login", login);
        query.setParameter("password", password);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Erro?: " + e.getMessage());
            return null;
        }

    }
}
