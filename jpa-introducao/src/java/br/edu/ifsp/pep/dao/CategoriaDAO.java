package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;

@Stateless
public class CategoriaDAO extends AbstractDAO<Categoria> {

    public Categoria buscaPorCodigo(Integer codigo){
        EntityManager em = getEntityManager();
        return em.find(Categoria.class, codigo);
    }
    
//    @Override
//    public void remover(Categoria entity){
//        Categoria categoria = buscaPorCodigo(entity.getCodigo());
//        super.remover(categoria);
//    }
}
