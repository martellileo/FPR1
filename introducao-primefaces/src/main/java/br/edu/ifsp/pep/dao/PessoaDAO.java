package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa>{

}
