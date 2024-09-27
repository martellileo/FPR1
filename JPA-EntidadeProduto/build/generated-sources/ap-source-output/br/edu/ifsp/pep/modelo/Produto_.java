package br.edu.ifsp.pep.modelo;

import br.edu.ifsp.pep.modelo.ProdutoStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-14T12:31:43", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Integer> codigo;
    public static volatile SingularAttribute<Produto, LocalDate> data_cadastro;
    public static volatile SingularAttribute<Produto, BigDecimal> valor;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, ProdutoStatus> status;

}