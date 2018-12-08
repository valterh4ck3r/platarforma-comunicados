/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author bernardes
 */
//Define que é a classe é uma entidade
@Entity
//Define o nome da tabela
@Table(name="TB_USUARIO")
//Valor que diferencia quem é aluno ou professor no usuario
@DiscriminatorValue(value = "A")

@PrimaryKeyJoinColumn(name="ID_ALUNO", referencedColumnName = "ID")
//Query que ordena os alunos
@NamedQueries(
    {
        @NamedQuery(
                name = Aluno.TODOS_ALUNOS,
                query = "SELECT a FROM Aluno a"
        )
    
    }
)
@Access(AccessType.FIELD)
public class Aluno extends Usuario implements Serializable {
    
    public static final String TODOS_ALUNOS = "TodosAlunos";

    //Mapeamento um para muitos (um aluno pode ter varos comentarios)
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, targetEntity = Comentario.class,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object obj) {
        
        return obj instanceof Aluno;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.comentarios);
        return hash;
    }
    
}
