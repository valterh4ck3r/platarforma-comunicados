/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author ALUNO
 */
public class Tag implements Serializable {
     @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
     
     @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "TXT_NOME", nullable = false, length = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
     
}
