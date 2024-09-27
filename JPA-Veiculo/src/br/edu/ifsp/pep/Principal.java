package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelos.Proprietario;
import br.edu.ifsp.pep.modelos.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");
    public static void main(String[] args) {
        Proprietario proprietario = new Proprietario();
        proprietario.setEmail("email@email.com");
        proprietario.setNome("João");
        proprietario.setTelefone("18 99999-8888");
        
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setAno(2000);
        veiculo1.setFabricante("VW");
        veiculo1.setProprietario(proprietario);
        
        EntityManager em = emf.createEntityManager();
        
        // começa transação
        em.getTransaction().begin();
        
        // armazena no banco
        em.persist(proprietario);
        em.persist(veiculo1);
        
        // comita e fecha transação
        em.getTransaction().commit();
        em.close();
    }
}
