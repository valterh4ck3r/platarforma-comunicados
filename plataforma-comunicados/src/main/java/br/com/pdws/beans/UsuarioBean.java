/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.beans;

import br.com.pdws.comunica.Usuario;
import br.com.pdws.servico.UsuarioServico;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author leandro
 */
@SessionScoped
@Named(value = "usuarioBean")
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioServico usuarioServico;

    private Usuario usuario;

    @PostConstruct
    public void iniciar() {
        usuario = usuarioServico.create();
    }
    
    public void salvar() {
        this.usuarioServico.persistence(this.usuario);
        this.usuario = new Usuario();
        //addMessage("Usuario cadastrado com sucesso!");
        //this.usuario = null;
    }


    public UsuarioServico getUsuarioServico() {
        return usuarioServico;
    }

    public void setUsuarioServico(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
