package br.edu.ifsp.pep.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;

@Entity
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "agencia", referencedColumnName = "agencia")
})
@DiscriminatorValue(value = "conta_corrente")
@NamedQueries(value = {
    @NamedQuery(name = "", query = "SELECT SUM(c.saldo) FROM ContaCorrente c")
})
public class ContaCorrente extends Conta{
    @Column(name="tarifa")
    private double tarifa;
}
