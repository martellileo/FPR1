package br.edu.ifsp.pep.modelos;

import java.util.Date;
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
@DiscriminatorValue(value = "conta_poupanca")
@NamedQueries(value = {
    @NamedQuery(name = "ContaPoupanca.listarAniversario",
            query = "SELECT c FROM ContaPoupanca c where c.dataCriacao = :data")
})
public class ContaPoupanca extends Conta{
    @Column(name="dataCriacao")
    private Date dataCriacao;
}
