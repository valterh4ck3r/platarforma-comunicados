/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.beans;

import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Professor;
import br.com.pdws.comunica.Usuario;
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
            
            this.aluno.setMatricula(this.matricula);
            salvarAluno();
        }else if(this.tipo.equals("Professor")){
            this.professor.setSiape(this.siape);
            this.professor.setCurso(this.aluno.getCurso());
            this.professor.setCpf(this.aluno.getCpf());
            this.professor.setName(this.aluno.getName());
            this.professor.setEmail(this.aluno.getEmail());
            this.professor.setSenha(this.aluno.getSenha());
            salvarProfessor();
        }
    }

    public void salvarAluno() {
        System.out.println(this.aluno.getName() +" "+ this.aluno.getCpf() + " " + this.aluno.getCurso()
            + "  " + this.aluno.getEmail() + "  " + this.aluno.getSenha());
        this.aluno.setMatricula(this.matricula);
        this.alunoServico.persistence(this.aluno);
        this.aluno = new Aluno();
        System.out.println("testou");
       // addMessage("Usuario cadastrado com sucesso!");
        
        this.alunoServico = null;
    }
    
    public void salvarProfessor(){
        this.professorServico.persistence(this.professor);
        this.professor = new Professor();
        this.professorServico.persistence(this.professor);
        this.professor = new Professor();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
    
   
 
    
}
