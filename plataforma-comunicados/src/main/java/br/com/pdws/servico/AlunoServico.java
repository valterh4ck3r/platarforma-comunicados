/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;
import br.com.pdws.comunica.Aluno;
import br.com.pdws.comunica.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless(name = "ejb/AlunoServico")
public class AlunoServico extends Servico<Aluno> {

   @PostConstruct
    public void init() {
        super.setClasse(Aluno.class);
    }

    @Override
    public Aluno create() {
        return new Aluno();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Aluno> getAllAlunos(){
        return super.findEntities(Aluno.TODOS_ALUNOS);
    }
    
}
