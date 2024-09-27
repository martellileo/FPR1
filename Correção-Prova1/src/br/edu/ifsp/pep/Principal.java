package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelo.Assalariado;
import br.edu.ifsp.pep.modelo.Comissionado;
import br.edu.ifsp.pep.modelo.Funcionario;
import br.edu.ifsp.pep.modelo.Gerente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("conexaoPU");

        adicionar();
        reajustarSalario(10);
        listarAssalariados();
        
        listarTodosFuncionarios();
    }
    
    private static void gravar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    private static void adicionar() {

        Gerente gerente = new Gerente(40, 1500, "Leo", "Leo", "leo");
        if (!existeLogin(gerente.getLogin())) {
            gravar(gerente);
        }
        
        Comissionado comissionado = new Comissionado(1500, 1500, "Natalia", "Nat", "nat");
        if(!existeLogin(comissionado.getLogin())){
            gravar(comissionado);
        }
        
        Assalariado assalariado = new Assalariado(1000, "Teste", "Tes", "tes");
        if(!existeLogin(assalariado.getLogin())) {
            gravar(assalariado);
        }

    }

    private static boolean existeLogin(String login) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionario> query = em.createNamedQuery("Funcionario.findByLogin", Funcionario.class);
        query.setParameter("login", login);
        Funcionario funcionario = null;
        try {
            funcionario = query.getSingleResult();
            System.out.println("Já existe um funcionário com o login informado.");
            return true;
        } catch (NoResultException e) {
        }

        System.out.println("Não existe.");
        return false;

    }

    private static void reajustarSalario(double porcentagem) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        javax.persistence.Query query = em.createNamedQuery("Assalariado.reajustarSalario");
        query.setParameter("porcentagem", porcentagem);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    private static void listarTodosFuncionarios() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionario> query = em.createNamedQuery("Funcionario.findAll", Funcionario.class);
        List<Funcionario> funcionarios = query.getResultList();
        System.out.println("--- TODOS OS FUNCIONÁRIOS ---");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

    }

    private static void listarAssalariados() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Assalariado> query = em.createNamedQuery("Assalariado.findAll", Assalariado.class);
        List<Assalariado> assalariados = query.getResultList();
        for (Assalariado assalariado : assalariados) {
            if (assalariado.getClass() == Assalariado.class) {
                System.out.println(assalariado);
            }
        }
    }
}
