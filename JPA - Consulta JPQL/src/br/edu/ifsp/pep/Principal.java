package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelos.Proprietario;
import br.edu.ifsp.pep.modelos.Veiculo;
import br.edu.ifsp.pep.modelos.VeiculoId;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Principal {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");

    public static void main(String[] args) {

        adicionar();

        consultas();

        consultaTipadaAno();
        
        consultaTipadaPlaca();
        
        consultaTipadaPlacaCidade();
    }

    private static void adicionar() {
        EntityManager em = emf.createEntityManager();

        Veiculo v1 = new Veiculo();
        v1.setAno(2000);
        v1.setFabricante("VW");
        VeiculoId v1d = new VeiculoId("ABC-2222", "Presidente epitacio");
        v1.setCodigo(v1d);
        // começa transação
        em.getTransaction().begin();

        // armazena no banco
        em.persist(v1);

        // comita e fecha transação
        em.getTransaction().commit();
        em.close();
    }

    private static void consultas() {
        EntityManager em = emf.createEntityManager();

        // a consulta é semelhante ao SQL (tabelas). Ex: Select * from veiculos
        //JPQL - baseada na classe(entidade)
        //Ex1: Select v from Veiculo v where v.codigo = 1
        //Ex2: from Veiculo v where v.ano = 2000;
        TypedQuery query
                = em.createQuery("SELECT v FROM Veiculo v WHERE v.ano = 2000", Veiculo.class);
        List resultList = query.getResultList();

        if (resultList != null) {
            for (Object carro : resultList) {
                Veiculo v = (Veiculo) carro;
                System.out.println(v.getCodigo().getPlaca());
            }
        }
    }

    private static void consultaTipadaAno() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Veiculo> query = em.createNamedQuery(
                "Veiculo.buscarPeloAno", Veiculo.class);
        List<Veiculo> resultList = query.getResultList();

        if (resultList != null) {
            for (Veiculo v : resultList) {
                System.out.println(v.getCodigo().getPlaca());
            }
        }
    }

    private static void consultaTipadaPlaca() {
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Veiculo> query = em.createNamedQuery(
            "Veiculo.buscarPelaPlaca", Veiculo.class);
        query.setParameter("placa", "ABC-2222");
        
        List<Veiculo> resultList = query.getResultList();

        if (resultList != null) {
            for (Veiculo v : resultList) {
                System.out.println(v.getCodigo().getCidade() +
                        " " + v.getCodigo().getPlaca());
            }
        }
    }
    
    private static void consultaTipadaPlacaCidade(){
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Veiculo> query = em.createNamedQuery(
            "Veiculo.buscarPelaPlacaECidade", Veiculo.class);
        query.setParameter("placa", "ABC-1111");
        query.setParameter("cidade", "Presidente Epitacio");
        
        try {
            Veiculo v = query.getSingleResult();
            System.out.println(v.getCodigo().getPlaca());
        } catch (NoResultException e) {
            System.out.println("Nao encontrou o veiculo");
        }
        
        
    }
}
