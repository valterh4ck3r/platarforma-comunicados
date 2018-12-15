/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.excecoes;

/**
 *
 * @author lucas
 */
public class ComunicadosException extends Exception {
    
    private String mensagem;    

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public ComunicadosException() {
        setMensagem("Precisa digitar algum comunicado.");
    }
    
    
}
