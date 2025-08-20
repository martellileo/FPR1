package br.edu.ifsp.pep.entidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
@NamedQueries(value = {
    @NamedQuery(name = "Pessoa.buscarTodos",
            query = "Select p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.buscarPeloCodigo",
            query = "From Pessoa p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pessoa.buscarGerente",
            query = "From Pessoa p WHERE p.tipoPessoa = br.edu.ifsp.pep.entidade.TipoPessoa.Gerente"),
    @NamedQuery(name = "Pessoa.buscarGerenteMenosCincoMil",
            query = "From Pessoa p WHERE p.tipoPessoa = br.edu.ifsp.pep.entidade.TipoPessoa.Gerente AND p.salario < 5000"),
    @NamedQuery(name = "Pessoa.salarioMedioGerentes", 
            query = "Select avg(p.salario) From Pessoa p WHERE p.tipoPessoa = br.edu.ifsp.pep.entidade.TipoPessoa.Gerente"),
    @NamedQuery(name = "Pessoa.desisto", 
            query = "SELECT p FROM Pessoa p WHERE p.tipoPessoa = br.edu.ifsp.pep.entidade.TipoPessoa.Gerente AND p.salario > (SELECT AVG(p2.salario) FROM Pessoa p2 WHERE p2.tipoPessoa = br.edu.ifsp.pep.entidade.TipoPessoa.Gerente);")
        })
public class Pessoa implements Serializable {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "salario", scale = 2, precision = 8, nullable = false)
    private BigDecimal salario;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String email;

    @Column(name = "tipo_pessoa", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "pessoa")
    private List<Venda> vendas;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pessoa_veiculo",
            joinColumns = @JoinColumn(name = "pessoa_codigo"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_codigo"))
    private List<Veiculo> veiculos;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_codigo", nullable = false)
    private Endereco endereco;

    @Override
    public String toString() {
        return "Pessoa {\n"
                + "  codigo = " + codigo + ",\n"
                + "  nome = '" + nome + "',\n"
                + "  dataNascimento = " + dataNascimento + ",\n"
                + "  salario = " + salario + ",\n"
                + "  email = '" + email + "',\n"
                + "  tipoPessoa = " + tipoPessoa + ",\n"
                + "  vendas = " + vendas + ",\n"
                + "  veiculos = " + veiculos + ",\n"
                + "  endereco = " + endereco + "\n"
                + '}';
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Pessoa() {
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
