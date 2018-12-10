/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;
import br.com.pdws.comunica.Comunicado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
//Classe que serve como mediador entre a entidade e o bean
@Stateless(name = "ejb/ComunicadoServico")
public class ComunicadoServico extends Servico<Comunicado> {

   @PostConstruct
    public void init() {
        super.setClasse(Comunicado.class);
    }

    @Override
    public Comunicado create() {
        return new Comunicado();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Comunicado> getAllComunicados(){
        return super.findEntities(Comunicado.TODOS_COMUNICADOS);
    }

}
