/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.servico;

import br.com.pdws.comunica.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author leandro
 */
@Stateless(name = "ejb/UsuarioServico")
public class UsuarioServico extends Servico<Usuario> {

   @PostConstruct
    public void init() {
        super.setClasse(Usuario.class);
    }

    @Override
    public Usuario create() {
        return new Usuario();
    }

    @Override
    public boolean exist(@NotNull Usuario usuario) {
        TypedQuery<Usuario> query
                = entityManager.createNamedQuery(Usuario.USUARIO_POR_ID, classe);
        query.setParameter(1, usuario.getId());
        return !query.getResultList().isEmpty();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario getUserPorEmail(String email){
        return super.findEntity(new Object[]{email}, Usuario.USUARIO_POR_EMAIL);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Usuario> getUserPorLetra(String letra){
        return super.findEntities(new Object[]{letra}, Usuario.USUARIO_POR_LETRA);
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Usuario> getUserPorNome(String nome){
        return super.findEntities(new Object[]{nome}, Usuario.USUARIO_POR_NOME);
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Usuario> getAllUsers(){
        return super.findEntities(Usuario.TODOS_USUARIOS);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario getUserPorCPF(String cpf){
        return super.findEntity(new Object[]{cpf}, Usuario.USUARIO_POR_CPF);
    }
    
    
}
