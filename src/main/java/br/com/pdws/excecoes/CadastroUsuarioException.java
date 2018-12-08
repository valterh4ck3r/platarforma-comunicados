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
//Exceção que avisa caso o email ja esteja sendo usado por algum usuario
public class CadastroUsuarioException extends Exception {

       private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    private void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

     public CadastroUsuarioException() {
         //Mensagem de retorno
         setMensagem("\"E-mail já usado por outro usuário.\n" + "Favor utilizar outro.\"");
         

    }
  
    
}
