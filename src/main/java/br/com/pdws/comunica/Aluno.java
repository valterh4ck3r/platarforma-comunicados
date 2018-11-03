/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bernardes
 */
@Entity
@Table(name="TB_ALUNO")
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name="ID_ALUNO", referencedColumnName = "ID")
@NamedQueries(
    {
        @NamedQuery(
                name = Aluno.TODOS_ALUNOS,
                query = "SELECT a FROM Aluno a"
        )
    
    }
)
public class Aluno extends Usuario implements Serializable {
    
    public static final String TODOS_ALUNOS = "TodosAlunos";
    
    @NotNull
    @Column(name = "TXT_MATRICULA", length = 14, nullable = false)
    private String matricula;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, targetEntity = Comentario.class,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }


    
}
