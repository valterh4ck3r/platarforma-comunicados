/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;

import br.com.pdws.comunica.Professor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


//Classe que serve como mediador entre a entidade e o bean
@Stateless(name = "ejb/ProfessorServico")
public class ProfessorServico extends Servico<Professor> {
    
   @PostConstruct
    public void init() {
        super.setClasse(Professor.class);
    }

    @Override
    public Professor create() {
        return new Professor();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Professor> getAllProfessores(){
        return super.findEntities(Professor.TODOS_PROFESSOR);
    }
}
