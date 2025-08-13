package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PessoaDAO {

    @PersistenceContext(name = "conexaoPU")
    private EntityManager em;

    public PessoaDAO() {
        System.out.println("PessoaDAO");
    }

    public void inserir(Pessoa p) {
        em.persist(p);
    }
}
