import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Comentario;
import br.com.pdws.comunica.Comunicado;
import br.com.pdws.comunica.Professor;
import br.com.pdws.excecoes.CadastroUsuarioException;
import br.com.pdws.excecoes.ComunicadosException;
import br.com.pdws.servico.AlunoServico;
import br.com.pdws.servico.ComentarioServico;
import br.com.pdws.servico.ComunicadoServico;
import br.com.pdws.servico.ProfessorServico;
import br.com.pdws.servico.UsuarioServico;
import br.com.pdws.util.ObjetosSessaoManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

    //Inicia o serviço
    @PostConstruct
    public void iniciar() {

        comunicado = comunicadoServico.create();
        comentario = comentarioServico.create();
        professor = professorServico.create();
    }

//Faz o envio do counicado
    public void salvarComunicado() throws ComunicadosException {
        
        professor = (Professor) ObjetosSessaoManager.pegarObjetoSessao("professor");
        
        //this.comunicado.addTags(tag);
        this.comunicado.setTexto(texto);
        this.comunicado.setProfessor(professor);
        this.comunicado.setDataCriacao(dataCriacao);
        
        try {
            comunicadoServico.persistence(comunicado);
        } catch (CadastroUsuarioException ex) {
            //Precisa tratar aqui
        }

       this.comunicado = null;
    }

    public List<Comunicado> getComunicados() {
        comunicados = comunicadoServico.getAllComunicados();
        return comunicados;
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
    
    private String enviarParaFeed() {

        return "Feed?faces-redirect";
    }
}