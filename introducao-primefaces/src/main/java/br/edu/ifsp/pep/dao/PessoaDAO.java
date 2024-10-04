package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PessoaDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void inserir(Pessoa p){
        em.persist(p);
    }
    
    public void alterar(Pessoa p){
        em.merge(p);
    }
    
    public void excluir(Pessoa p){
//        Pessoa pessoa = em.find(Pessoa.class, p.getCodigo());
//        em.remove(pessoa);

//        em.merge(p);
        em.remove(em.merge(p));
    }
}
