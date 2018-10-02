/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROFESSOR")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "ID_PROFESSOR", referencedColumnName = "ID")
public class Professor extends Usuario implements Serializable {

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comunicado> comunicados;

    public List<Comunicado> getComunicado() {
        return comunicados;
    }

    public boolean adicionar(Comunicado comunicado) {
        comunicado.setProfessor(this);
        return comunicados.add(comunicado);
    }

}
