package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelo.Produto;
import br.edu.ifsp.pep.modelo.ProdutoStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conxaoPU");
    
    public static void main(String[] args) {
        adicionar();
    }

    private static void adicionar() {
        Produto p1 = new Produto("maça", LocalDate.now(), ProdutoStatus.EmEstoque, new BigDecimal(1.50));
        Produto p2 = new Produto("uva", LocalDate.now(), ProdutoStatus.EmEstoque, new BigDecimal(1.50));
        Produto p3 = new Produto("abacaxi", LocalDate.now(), ProdutoStatus.EmEstoque, new BigDecimal(1.50));
        Produto p4 = new Produto("pera", LocalDate.now(), ProdutoStatus.Esgotado, new BigDecimal(1.50));
        Produto p5 = new Produto("banana", LocalDate.now(), ProdutoStatus.Esgotado, new BigDecimal(1.50));
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        
        em.getTransaction().commit();
        
        em.close();
    }
}
