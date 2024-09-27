package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pessoa", uniqueConstraints = {
    @UniqueConstraint(name = "unique_cpf_nome", columnNames = {"nome", "cpf"}),
    @UniqueConstraint(name = "unique_cpf_status", columnNames = {"cpf", "status"}),
    @UniqueConstraint(name = "unique_status", columnNames = {"status"})
})
public class Pessoa implements Serializable{
    
    @Id
    @Column(name = "codigo") // nome da coluna
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int codigo;
    
    @Column(name = "cpf", length = 14, nullable = true)
    private String cpf;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    // enum
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true, length = 7)
    private PessoaStatus status;
    
    
    // numeros decimais
    @Column(name="salario")
    private double salario;

    @Column(name="vale_transporte", nullable = false, precision = 8, scale = 3)
    private BigDecimal valeTransporte;
    
    
    // datas
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @Column(name = "administrador")
    private boolean administrador;
    
    @Column(name = "financeiro")
    private Boolean financeiro;
    
    @Column(name = "tipo1", length = 15)
    private char tipo1;
    
    @Column(name = "tipo2", length = 20)
    private Character tipo2;
    
    @Lob
    @Column(name = "biografia")
    private String biografia;
    
    @Column(name = "foto", columnDefinition = "MEDIUMBLOB")
    private byte[] foto;
    
    public Pessoa() {
    }
    
    public Pessoa(String nome, int codigo, PessoaStatus status) {
        this.nome = nome;
        this.codigo = codigo;
        this.status = status;
    }

    public Pessoa(int codigo, String cpf, String nome, PessoaStatus status, double salario, BigDecimal valeTransporte, Date dataNascimento, LocalDate dataAlteracao, LocalDateTime dataCadastro) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.status = status;
        this.salario = salario;
        this.valeTransporte = valeTransporte;
        this.dataNascimento = dataNascimento;
        this.dataAlteracao = dataAlteracao;
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PessoaStatus getStatus() {
        return status;
    }

    public void setStatus(PessoaStatus status) {
        this.status = status;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public BigDecimal getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(BigDecimal valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Boolean getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Boolean financeiro) {
        this.financeiro = financeiro;
    }

    public char getTipo1() {
        return tipo1;
    }

    public void setTipo1(char tipo1) {
        this.tipo1 = tipo1;
    }

    public Character getTipo2() {
        return tipo2;
    }

    public void setTipo2(Character tipo2) {
        this.tipo2 = tipo2;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
