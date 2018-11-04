/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import java.io.Serializable;
import java.util.List;
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

@Entity
@Table(name="TB_USUARIO")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName = "ID")
@NamedQueries(
    {
        @NamedQuery(
                name = Professor.TODOS_PROFESSOR,
                query = "SELECT p FROM Professor p"
        )
    
    }
)
@Access(AccessType.FIELD)
public class Professor extends Usuario implements Serializable {
    
    public static final String TODOS_PROFESSOR = "TodosProfessores";

   @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, targetEntity = Comunicado.class,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comunicado> comunicados;
   
    public List<Comunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }
    
}
