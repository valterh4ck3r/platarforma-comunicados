package br.com.pdws.beans;

import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Professor;
import br.com.pdws.comunica.Usuario;
import br.com.pdws.servico.AlunoServico;
import br.com.pdws.servico.ProfessorServico;
import br.com.pdws.servico.UsuarioServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable {
   
    private Aluno aluno;
    private String nome;
    private String email;
    private String senha;
    private Professor professor;
    private String tipo;
    
    @EJB
    AlunoServico alunoServico;
    @EJB
    ProfessorServico professorServico;
    @EJB
    UsuarioServico usuarioServico;
    
    @PostConstruct
    public void iniciar() {
        
        aluno = alunoServico.create();
        professor = professorServico.create();
        tipo = new String();
    }
    
    //Verifica o tipo do o usuário a ser cadastrado e redireciona para o método de persistencia de acordo com o tipo
    public void checaTipoUsuario(){
        
        if(this.tipo.equals("Estudante")){
            
            salvarAluno();
            
        }else if(this.tipo.equals("Professor")){
           
            salvarProfessor();
        }
    }

    public void salvarAluno() {
        
        this.aluno.setName(nome);
        this.aluno.setEmail(email);
        this.aluno.setSenha(senha);

        this.alunoServico.persistence(this.aluno);
        setNome(null);
        setEmail(null);
        setSenha(null);

    }
    
    public void salvarProfessor(){
        
        this.professor.setName(nome);
        this.professor.setEmail(email);
        this.professor.setSenha(senha);

        this.professorServico.persistence(this.professor);
        setNome(null);
        setEmail(null);
        setSenha(null);
    }
    
    //Esse método pega os dados do usuário, se houver
    //PRECISA DE UM MÉTODO QUE REDIRECIONA PARA A PÁGINA APÓS O LOGIN OU TRATA O ERRO QUANDO NAO HOUVER USER CADASTRADO
    public Usuario pegarUsuario(){
        Usuario usuario = usuarioServico.getUserPorEmail(email);
        
            if(usuario != null && usuario.getSenha().equals(senha))
                return usuario;
            
            return usuario;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAlunoServico(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    public void setProfessorServico(ProfessorServico professorServico) {
        this.professorServico = professorServico;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getTipo() {
        return tipo;
    }

    public AlunoServico getAlunoServico() {
        return alunoServico;
    }

    public ProfessorServico getProfessorServico() {
        return professorServico;
    }
   
}
