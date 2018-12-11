/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;

import br.com.pdws.comunica.Comentario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
//Classe que serve como mediador entre a entidade e o bean

@Stateless(name = "ejb/ComentarioServico")
public class ComentarioServico extends Servico<Comentario> {

    @PostConstruct
    public void init() {
        super.setClasse(Comentario.class);
    }

    @Override
    public Comentario create() {
        return new Comentario();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Comentario> getAllComentarios() {
        return super.findEntities(Comentario.TODOS_COMENTARIOS);
    }

}
