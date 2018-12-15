/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;
import br.com.pdws.comunica.Tag;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless(name = "ejb/TagServico")
public class TagServico extends Servico<Tag> {

   @PostConstruct
    public void init() {
        super.setClasse(Tag.class);
    }

    @Override
    public Tag create() {
        return new Tag();
    }

}