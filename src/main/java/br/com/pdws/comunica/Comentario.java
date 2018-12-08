/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ALUNO
 */
//Define que é a classe é uma entidade
@Entity
//Define o nome da tabela
@Table(name = "TB_COMENTARIO")
public class Comentario implements Serializable {
//Define as colunas que a tabela ira conter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    //Define que a coluna texto não pode estar em branco
    //antes de commit, tendo no minimo dois e maximo 50 caracters
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "TXT_TEXTO", nullable = false, length = 50)
    private String texto;

    //Varios para um (um aluno pode ter varios comentarios)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID", nullable = false)
    private Aluno aluno;

    //Varios para um (um comunica pode ter varios comentarios)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COMUNICADO", referencedColumnName = "ID")
    private Comunicado comunicado;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
//Define a coluna texto que ira armazenar o texto
    public String getTexto() {
        return texto;
    }
//Define a coluna comunicado que ira armazenar o comunicado
    public Comunicado getComunicado() {
        return comunicado;
    }

    public void setComunicado(Comunicado comunicado) {
        this.comunicado = comunicado;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
