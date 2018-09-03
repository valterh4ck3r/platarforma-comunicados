/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ALUNO
 */
@Entity
@Table(name = "TB_COMUNICADO")
public class Comunicado implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "TXT_TEXTO", nullable = false, length = 50)
    private String texto;

    @NotNull
    @Column(name = "TXT_COMENTARIO", length = 30, nullable = false)
    protected String comentario;

    // Para fazer mapeamento
     @ManyToMany
       @JoinTable(name="pessoa_has_notebooks", joinColumns=
    {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
      {@JoinColumn(name="notebook_id")})
    private List notebooks;
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    
}