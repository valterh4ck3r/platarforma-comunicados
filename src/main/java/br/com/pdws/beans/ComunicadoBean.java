package br.com.pdws.beans;

import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Comentario;
import br.com.pdws.comunica.Comunicado;
import br.com.pdws.comunica.Professor;
import br.com.pdws.comunica.Tag;
import br.com.pdws.comunica.Usuario;
import br.com.pdws.excecoes.CadastroUsuarioException;
import br.com.pdws.servico.AlunoServico;
import br.com.pdws.servico.ComentarioServico;
import br.com.pdws.servico.ComunicadoServico;
import br.com.pdws.servico.ProfessorServico;
import br.com.pdws.servico.TagServico;
import br.com.pdws.servico.UsuarioServico;
import br.com.pdws.util.ObjetosSessaoManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Leandro
 */
//Classe que faz a interceptação dos dados
@ManagedBean(name = "comunicadoBean")
@RequestScoped
public class ComunicadoBean implements Serializable {

    private List<Comunicado> comunicados;
    private Aluno aluno;
    private long id;
    private Professor professor;
    private String tag;
    private String texto;
    private String email;
    private String senha;
    private Comunicado comunicado;
    private Comentario comentario;
    private Date dataCriacao;
    private Tag tag1;

    public Tag getTag1() {
        return tag1;
    }

    public void setTag1(Tag tag1) {
        this.tag1 = tag1;
    }

    @EJB
    AlunoServico alunoServico;
    
    @EJB
    ProfessorServico professorServico;
    
    @EJB
    UsuarioServico usuarioServico;
    
    @EJB
    ComunicadoServico comunicadoServico;
    
    @EJB
    ComentarioServico comentarioServico;
    
    @EJB
    TagServico tagServico;

    //Inicia o serviço
    @PostConstruct
    public void iniciar() {

        comunicado = comunicadoServico.create();
        comentario = comentarioServico.create();
        professor = professorServico.create();
    }

//Faz o envio do counicado
    public void salvarComunicado() {
//        this.comunicado.addTags(tag);
        this.comunicado.setID( (Long) ObjetosSessaoManager.pegarObjetoSessao(Long.toString(id)));
        this.comunicado.setTexto(texto);
        this.comunicado.setProfessor(professor);
        this.comunicado.setDataCriacao(dataCriacao);
        this.comunicado.

        setTexto(null);
        setProfessor(null);
        setDataCriacao(null);
    }
    
    public void inserirTag(){
        try {
            tagServico.persistence(tag1);
        } catch (CadastroUsuarioException ex) {
            Logger.getLogger(ComunicadoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addTagComunicado(){
        this.comunicado.addTags(tag);
    }

    public List<Comunicado> getComunicados() {
        comunicados = comunicadoServico.getAllComunicados();
        return comunicados;
    }

    //Esse método pega os dados do usuário, se houver
    //PRECISA DE UM MÉTODO QUE REDIRECIONA PARA A PÁGINA APÓS O LOGIN OU TRATA O ERRO QUANDO NAO HOUVER USER CADASTRADO
    public void pegarUsuario() {

        Usuario usuario = usuarioServico.getUserPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            ObjetosSessaoManager.guardarObjetoSessao("usuario", usuario);
        }

        enviarParaFeed();
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public AlunoServico getAlunoServico() {
        return alunoServico;
    }

    public ProfessorServico getProfessorServico() {
        return professorServico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Comunicado getComunicado() {
        return comunicado;
    }

    public void setComunicado(Comunicado comunicado) {
        this.comunicado = comunicado;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String enviarParaFeed() {

        return "Feed?faces-redirect";
    }

}