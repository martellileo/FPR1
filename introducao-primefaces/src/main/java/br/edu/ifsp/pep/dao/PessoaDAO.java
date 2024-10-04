package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PessoaDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void inserir(Pessoa p) {
        em.persist(p);
    }

    public void alterar(Pessoa p) {
        em.merge(p);
    }

    public void excluir(Pessoa p) {

//        Pessoa pessoa = em.find(Pessoa.class, p.getCodigo());
//        if (pessoa != null) {
//            em.remove(pessoa);
//        }

        //Criar ou alterar
        //        em.remove(p);
        em.remove(em.merge(p));

    }

}
