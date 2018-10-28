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

@Entity
@Table(name="TB_PROFESSOR")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID_PROFESSOR", referencedColumnName = "ID")
@NamedQueries(
    {
        @NamedQuery(
                name = Professor.TODOS_PROFESSOR,
                query = "SELECT p FROM Professor p"
        )
    
    }
)
public class Professor extends Usuario implements Serializable {
    
    public static final String TODOS_PROFESSOR = "TodosProfessores";
     
    @NotNull
    @Column(name = "TXT_SIAPE", length = 14, nullable = false)
    private String siape;

   @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, targetEntity = Comunicado.class,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comunicado> comunicados;
   
   
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public List<Comunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }
    
    
}
