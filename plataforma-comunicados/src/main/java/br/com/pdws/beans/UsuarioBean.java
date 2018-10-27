/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.beans;

import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Professor;
import br.com.pdws.servico.AlunoServico;
import br.com.pdws.servico.ProfessorServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author isabella
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable {
   
    private Aluno aluno;
    private String nome;
    private String email;
    private String cpf;
    private String curso;
    private String senha;
    private Professor professor;
    private String tipo;
    private String matricula;
    private String siape;
    
    @EJB
    AlunoServico alunoServico;
    @EJB
    ProfessorServico professorServico;
    
    @PostConstruct
    public void iniciar() {
        
        aluno = alunoServico.create();
        professor = professorServico.create();
        tipo = new String();
        matricula = new String();
        siape = new String();
    }
    
    public void checaTipoUsuario(){
        
        if(this.tipo.equals("Estudante")){
            
            salvarAluno();
            
        }else if(this.tipo.equals("Professor")){
           
            salvarProfessor();
        }
    }

    public void salvarAluno() {
        
        this.aluno.setName(nome);
        this.aluno.setCpf(cpf);
        this.aluno.setCurso(curso);
        this.aluno.setEmail(email);
        this.aluno.setMatricula(matricula);
        this.aluno.setSenha(senha);
        
        System.out.println(this.aluno.getName() +" "+ this.aluno.getCpf() + " " + this.aluno.getCurso()
            + "  " + this.aluno.getEmail() + "  " + this.aluno.getSenha());

        this.alunoServico.persistence(this.aluno);
        System.out.println("testou");
       // addMessage("Usuario cadastrado com sucesso!");

    }
    
    public void salvarProfessor(){
        
        this.professor.setName(nome);
        this.professor.setCpf(cpf);
        this.professor.setSiape(siape);
        this.professor.setCurso(curso);
        this.professor.setEmail(email);

        this.professorServico.persistence(this.professor);
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public void setAlunoServico(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    public void setProfessorServico(ProfessorServico professorServico) {
        this.professorServico = professorServico;
    }
    
    
    
}
