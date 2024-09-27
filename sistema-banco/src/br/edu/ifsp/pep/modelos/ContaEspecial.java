package br.edu.ifsp.pep.modelos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;

@Entity
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "agencia", referencedColumnName = "agencia")
})
@NamedQueries(value = {
    @NamedQuery(name = "ContaEspecial.listarSaldoMenorZero", 
            query = "SELECT c.saldo FROM ContaEspecial c WHERE c.saldo <= 0"),
    @NamedQuery(name = "ContaEspecial.listarMaiorSaldo", 
            query = "SELECT MAX(c.saldo) FROM ContaEspecial c")
})
@DiscriminatorValue(value = "conta_especial")
public class ContaEspecial extends Conta {
    @Column(name="limite")
    private double limite;
}
