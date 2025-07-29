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

        adicionar(2014, "Porsche", "ABC-1234", "Presidente Prudente");
        adicionar(2000, "Chevrolet", "CBA-4321", "Presidente Epitácio");
        adicionar(2010, "Lamborghini", "ABC-1111", "Presidente Epitácio");
        adicionar(2002, "Honda", "ABC-2222", "Presidente Prudente");

        consultas();
        
        System.out.println();

        consultaTipadaAno();
        
        System.out.println();
        
        consultaTipadaPlaca();
        
        System.out.println();
        
        consultaTipadaPlacaCidade();
        
        System.out.println();
        
        createNativeQuery();
        
        System.out.println();
        
        aggregationFunctions();
        
        System.out.println();
        
        aggregationFunctionGroup();
    }

    private static void adicionar(Integer ano, String fabricante, String placa, String cidade) {
        EntityManager em = emf.createEntityManager();

        Veiculo v1 = new Veiculo();
        v1.setAno(ano);
        v1.setFabricante(fabricante);
        VeiculoId v1d = new VeiculoId(placa, cidade);
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
                System.out.println("Busca placa quando ano = 2000: " + v.getCodigo().getPlaca());
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
                System.out.println("Consulta tipada ano = 2000: " + v.getCodigo().getPlaca());
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
                System.out.println("Consulta tipada placa - Carro: " + v.getCodigo().getCidade() +
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
            System.out.println("Consulta tipada placa+cidade - Modelo: " + v.getFabricante());
        } catch (NoResultException e) {
            System.out.println("Nao encontrou o veiculo");
        }
    }
    
    private static void createNativeQuery(){
        EntityManager em = emf.createEntityManager();
        Query nativeQuery = em.createNativeQuery(
            "select * from veiculo v");
        
        List veiculos = nativeQuery.getResultList();
        for (Object obj : veiculos) {
            Object result[] = (Object[]) obj;
            
            System.out.println("Ano: " + result[0]);
            System.out.println("Modelo: " + result[1]);
            System.out.println("Cidade: " + result[2]);
            System.out.println("Placa: " + result[3]);
        }
    }
    
    private static void aggregationFunctions(){
        EntityManager em = emf.createEntityManager();
        
        //COUNT
        TypedQuery<Long> queryCount = em.createQuery(
            "SELECT COUNT(v) FROM Veiculo v", Long.class);
        Long resultCount = queryCount.getSingleResult();
        System.out.println("Count: " + resultCount);
        
        //MAX
        TypedQuery<Integer> queryMax = em.createQuery(
            "SELECT MAX(v.ano) FROM Veiculo v", Integer.class);
        Integer resultAno = queryMax.getSingleResult();
        System.out.println("Max: " + resultAno);
        
        //AVG
        TypedQuery<Double> queryAvg = em.createQuery(
            "SELECT AVG(v.ano) FROM Veiculo v", Double.class);
        Double resultAvg = queryAvg.getSingleResult();
        System.out.println("AVG: " + resultAvg);
        
        //MIN
        TypedQuery<Integer> queryMin = em.createQuery(
            "SELECT MIN(v.ano) FROM Veiculo v", Integer.class);
        Integer resultMin = queryMin.getSingleResult();
        System.out.println("Min: " + resultMin);
        
        //SUM
        TypedQuery<Long> querySum = em.createQuery(
            "SELECT SUM(v.ano) FROM Veiculo v", Long.class);
        Long resultSum = querySum.getSingleResult();
        System.out.println("Sum: " + resultSum);
    }
    
    private static void aggregationFunctionGroup(){
        EntityManager em = emf.createEntityManager();
        
        //COUNT
        TypedQuery<Object[]> queryCount = em.createQuery(
            "SELECT v.codigo.cidade, COUNT(v) FROM Veiculo v GROUP BY v.codigo.cidade", Object[].class);
        
        List<Object[]> resultListCount = queryCount.getResultList();
        
        for (Object[] result : resultListCount) {
            String cidade = (String) result[0];
            Long count = (Long) result[1];
            System.out.println("Cidade: " + cidade + " - Count: " + count);
        }
        
        System.out.println("-----");
        
        //MAX
        TypedQuery<Object[]> queryMax = em.createQuery(
            "SELECT v.codigo.cidade, MAX(v.ano) FROM Veiculo v GROUP BY v.codigo.cidade", Object[].class);
        
        List<Object[]> resultListMax = queryMax.getResultList();
        for (Object[] result : resultListMax) {
            String cidade = (String) result[0];
            Integer max = (Integer) result[1];
            System.out.println("Cidade: " + cidade + " - Max: " + max);
        }
        
        System.out.println("-----");
        
        //MIN
        TypedQuery<Object[]> queryMin = em.createQuery(
            "SELECT v.codigo.cidade, MIN(v.ano) FROM Veiculo v GROUP BY v.codigo.cidade", Object[].class);
        List<Object[]> resultListMin = queryMin.getResultList();
        for (Object[] result : resultListMin) {
            String cidade = (String) result[0];
            Integer min = (Integer) result[1];
            System.out.println("Cidade: " + cidade + " - Min: " + min);
        }
    }
}
