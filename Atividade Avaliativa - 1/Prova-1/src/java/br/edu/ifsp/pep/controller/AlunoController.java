/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.AlunoDAO;
import br.edu.ifsp.pep.dao.CursoDAO;
import br.edu.ifsp.pep.dao.DisciplinaDAO;
import br.edu.ifsp.pep.entidade.Aluno;
import br.edu.ifsp.pep.entidade.Curso;
import br.edu.ifsp.pep.entidade.Disciplina;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "alunoController")
@SessionScoped
public class AlunoController implements Serializable{
    @Inject()
    private AlunoDAO alunoDAO;
    
    @Inject()
    private CursoDAO cursoDAO;
    
    @Inject()
    private DisciplinaDAO disciplinaDAO;
    
    public void inserir(){
        List<Disciplina> disciplinas = new ArrayList();
        
        //Curso
        Curso c1 = new Curso();
        c1.setNomeCurso("BCC");
        cursoDAO.inserir(c1);
        
        
        //Disciplinas
        Curso curso = (Curso) cursoDAO.buscaPorCodigo(1);
        Disciplina d1 = new Disciplina();
        d1.setNomeDisciplina("FP1");
        d1.setCurso(curso);
        Disciplina d2 = new Disciplina();
        d2.setNomeDisciplina("FP2");
        d2.setCurso(curso);
        Disciplina d3 = new Disciplina();
        d3.setNomeDisciplina("FP3");
        d3.setCurso(curso);
        disciplinaDAO.inserir(d1);
        disciplinaDAO.inserir(d2);
        disciplinaDAO.inserir(d3);
        
        
        //Alunos
        disciplinas.add(d1);
        disciplinas.add(d2);
        disciplinas.add(d3);
        Aluno a1 = new Aluno();
        a1.setNome("Leo");
        a1.setCurso(curso);
        a1.setDisciplinas(disciplinas);
        Aluno a2 = new Aluno();
        a2.setNome("Natalia");
        a2.setCurso(curso);
        a2.setDisciplinas(disciplinas);
        alunoDAO.inserir(a1);
        alunoDAO.inserir(a2);
        
        System.out.println("Valores inseridos no db");
    }
    
    public void buscarAlunoCodigo(){
        List<Aluno> alunos = alunoDAO.buscarAlunosCodigo(1);
        System.out.println("Alunos Matriculados no Curso 1");
        System.out.println(alunos);
    }
    
    public void buscarDisciplinasAlunoMatriculado(){
        List<Disciplina> disciplinas = (List<Disciplina>) disciplinaDAO.buscarDisciplinasAlunoMatriculado(1);
        System.out.println("Disciplinas que o Aluno 1 está matriculado");
        System.out.println(disciplinas);
    }
    
    public void contagemDisciplinas(){
        Long contagem = cursoDAO.contagemDisciplinas(1);
        System.out.println("Contagem das Disciplinas presente no Curso 1");
        System.out.println(contagem);
    }
}
