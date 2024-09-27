package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelo.Pessoa;
import br.edu.ifsp.pep.modelo.PessoaStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");

    public static void main(String[] args) {

        adicionar();
        alterar();
        
        // testePersist();

    }

    private static void adicionar() {
        Pessoa p1 = new Pessoa(1, "393.649.138.09", "Leo", PessoaStatus.Ativa, 15000.59, new BigDecimal(200.891), new Date(), LocalDate.now(), LocalDateTime.now());
        Pessoa p2 = new Pessoa(2, "123.456.789-01", "Nat", PessoaStatus.Inativa, 15000.59, new BigDecimal(200.897), new Date(), LocalDate.now(), LocalDateTime.now());

        // gerencia a entidade (Transação, CRUD)
        EntityManager em = emf.createEntityManager();

        // inicia uma transação
        em.getTransaction().begin();

        // gravar o objeto P no banco de dados (INSERT)
        em.persist(p1);
        em.persist(p2);

        // manda pro banco
        em.getTransaction().commit();
        
        // fecha transação
        em.close();
    }

    private static void alterar() {
        EntityManager em = emf.createEntityManager();

        Pessoa p1 = em.find(Pessoa.class, 1);
        p1.setNome("Leo Martelli");

        em.getTransaction().begin();
        em.merge(p1);// altera ou cria
        em.getTransaction().commit();
        
        // fecha a conexão
        em.close();
    }

    private static void testePersist() {
        Pessoa p = new Pessoa("Xxxx", 1, PessoaStatus.Inativa);

        // gerencia a entidade (Transação, CRUD)
        EntityManager em = emf.createEntityManager();

        // inicia uma transação
        em.getTransaction().begin();

        // gravar o objeto P no banco de dados (INSERT)
        // em.persist(p);
        em.merge(p);
        
        // manda pro banco
        em.getTransaction().commit();
        
        // fecha transação
        em.close();
    }
}
