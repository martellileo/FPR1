package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaId implements Serializable {
    @Column(name="numero")
    private int numero;
    
    @Column(name="agencia", length= 20)
    private String agencia;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public ContaId() {
    }
}
