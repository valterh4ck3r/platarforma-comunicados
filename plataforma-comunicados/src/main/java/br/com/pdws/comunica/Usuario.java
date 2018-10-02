/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_USUARIO")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = Usuario.USUARIO_POR_EMAIL,
                    query = "SELECT u FROM Usuario u WHERE u.email LIKE ?1"
            )
            ,
            @NamedQuery(
                    name = Usuario.USUARIO_POR_ID,
                    query = "SELECT u FROM Usuario u WHERE u.id LIKE ?1"
            )
            ,
            @NamedQuery(
                    name = Usuario.USUARIO_POR_LETRA,
                    query ="SELECT u FROM Usuario u WHERE u.name LIKE ?1 ORDER BY u.id"
            )
            ,            
            @NamedQuery(
                    name = Usuario.USUARIO_POR_NOME,
                    query = "SELECT u FROM Usuario u WHERE u.name LIKE ?1 ORDER BY u.id"
            )
            ,            
            @NamedQuery(
                    name = Usuario.TODOS_USUARIOS,
                    query = "SELECT u FROM Usuario u"
            )
            ,            
            @NamedQuery(
                    name = Usuario.USUARIO_POR_CPF,
                    query = "SELECT u FROM Usuario u WHERE u.cpf LIKE ?1"
            )
        }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC_USUARIO",
        discriminatorType = DiscriminatorType.STRING, length = 1)
public class Usuario extends Entidade implements Serializable {

    public static final String USUARIO_POR_NOME = "UserPorNome";
    public static final String USUARIO_POR_EMAIL = "UserPorEmail";
    public static final String USUARIO_POR_LETRA = "UserPorLetra";
    public static final String USUARIO_POR_ID = "UserPorId";
    public static final String TODOS_USUARIOS = "AllUsers";
    public static final String USUARIO_POR_CPF = "UserPorCpf";
    
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "TXT_NOME", nullable = false, length = 50)
    private String name;

    @NotNull
    @Email
    @Column(name = "TXT_EMAIL", length = 30, nullable = false)
    protected String email;
    
    @NotNull
    @Column(name = "TXT_SENHA", length = 30, nullable = false)
    protected String senha;
    
    @NotNull
    @Column(name = "TXT_CURSO")
    protected String curso;   
    
    @NotNull
    @Column(name = "TXT_CPF")
    protected String cpf;    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
   
}
