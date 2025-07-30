package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {
    
    @Inject()
    private PessoaDAO pessoaDAO;
    
    public void inserir() {
        Pessoa p = new Pessoa();
        
        p.setNome("Leo");
        p.setDataNascimento(LocalDate.now());
        p.setEmail("l@email.com");
        p.setSalario(new BigDecimal(1000));
        p.setTipoPessoa(TipoPessoa.Administrador);
        
        pessoaDAO.inserir(p);
    }    
}
