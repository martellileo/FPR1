package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = {
    @NamedQuery(name = "Conta.listarMenorIgualZero", query = "SELECT c FROM Conta c WHERE c.saldo <= 0")
})
@DiscriminatorColumn(name = "tipoConta")
public class Conta implements Serializable{
    @EmbeddedId
    private ContaId codigo;
    
    @Column(name="saldo")
    private double saldo;
    
//    @ManyToOne
//    @JoinColumn(name="cliente_codigo")
//    private Cliente cliente;

    public Conta() {
    }

    public ContaId getCodigo() {
        return codigo;
    }

    public void setCodigo(ContaId codigo) {
        this.codigo = codigo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
    
    
}
