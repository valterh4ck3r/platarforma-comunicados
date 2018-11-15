/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author lucas
 * 
 * CLASSE CRIADA PARA GERENCIAR O ARMAZENAMENTO DE OBJETOS NA SESSÃO
 * 
 * 
 */
public class ObjetosSessaoManager {
    
    public static Object pegarObjetoSessao(String nome) {
        
            return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(nome);
    }
    
    public static boolean guardarObjetoSessao(String nome, Object objeto) {
        
            FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(nome, objeto);
            return true;
    }
    
}
