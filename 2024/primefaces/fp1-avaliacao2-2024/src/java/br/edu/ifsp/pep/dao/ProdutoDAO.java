package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author cesar
 */
@Stateless
public class ProdutoDAO extends AbstractDAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> findAll() {
        return super.findAll();
    }
}
