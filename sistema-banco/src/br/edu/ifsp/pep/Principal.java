package br.edu.ifsp.pep;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexaoPU");
    
    public static void main(String[] args) {
        
    }
    
}
