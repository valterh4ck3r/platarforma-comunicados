/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdws.comunica;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;

/**
 *
 * @author bernardes
 */
public class Util {

  public static void enviarEmail(String from , String subject , String to , String content) throws IOException{
  
      Email fromEmail = new Email(from);
      Email toEmail = new Email(to);
      Content contentEmail = new Content("text/plain", content);
      Mail mail = new Mail(fromEmail, subject, toEmail, contentEmail);

      SendGrid sg = new SendGrid("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");
      Request request = new Request();
      try {
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
      } catch (IOException ex) {
        throw ex;
      }
  }

}