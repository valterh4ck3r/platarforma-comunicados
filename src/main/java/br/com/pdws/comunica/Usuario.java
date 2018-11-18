/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC_USUARIO",
        discriminatorType = DiscriminatorType.STRING, length = 1)
@Access(AccessType.FIELD)
@NamedQueries(
    {
        @NamedQuery(
                name = Usuario.USUARIO_POR_EMAIL,
                query = "SELECT u FROM Usuario u where u.email LIKE :email "
        )

    }
)
public abstract class Usuario implements Serializable {

    public static String USUARIO_POR_CPF;
    public static String TODOS_USUARIOS;
    public static String USUARIO_POR_NOME;
    public static String USUARIO_POR_LETRA;
    public static final String USUARIO_POR_EMAIL = "Emails";
    public static String USUARIO_POR_ID;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "TXT_NOME", nullable = false, length = 50)
    private String name;

    @NotNull
    @Email
    @Column(name = "TXT_EMAIL", length = 30, nullable = false, unique = true)
    protected String email;
    
    @NotNull
    @Column(name = "TXT_SENHA", length = 30, nullable = false)
    protected String senha;
  
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
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
}