/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author ALUNO
 */
//Define que a classe é uma entidade
@Entity
//Define o nome da entidade na tabela
@Table(name = "TB_COMUNICADO")
//Query que ordena os comunicados
@NamedQueries(
        {
            @NamedQuery(
                    name = Comunicado.TODOS_COMUNICADOS,
                    query = "SELECT a FROM Comunicado a"
            )

        }
)
public class Comunicado implements Serializable {

    public static final String TODOS_COMUNICADOS = "TodosComunicados";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    //Define que a coluna texto não pode ser branca e no maximo
    //255 e minimo 2 caracters
    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "TXT_TEXTO", nullable = false, length = 255)
    private String texto;

    //Define uma coleção de elementos apontada para a coluna TAGS (array de tags)
    @ElementCollection
    @CollectionTable(name = "TB_TAGS",
            joinColumns = @JoinColumn(name = "ID"))

    @Column(name = "TXT_TAGS")
    protected Collection<String> tags;

    //Um para muitos (um comunicado pode ter varios comentarios)
    @OneToMany(mappedBy = "comunicado", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
//Muitos para um (um professor pode ter varios comunicados)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private Professor professor;
//Coluna para datas que é temporal (presente - futuro)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;

    //Precisa ser determinado antes de ser commitado
    @PrePersist
    protected void setDataCriacao() {
        this.setDataCriacao(new Date());
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void addTags(String tag) {
        if (tags == null) {
            tags = new HashSet<>();
        }
        tags.add(tag);
    }

}
