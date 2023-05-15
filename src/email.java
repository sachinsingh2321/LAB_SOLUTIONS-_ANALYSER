/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AmanTomar
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class email {
    
    public String to = "lakmanishra@gmail.com";
     public String from = "sachinrrrrrock0890@gmail.com";
     public String pass ="sachinsingh";
     public String subj = "Your complain is register succesfully";
     public String msg = "hello bro what we will do in ca  ";
     
     public void esend (){
         Properties properties = new Properties();
         properties.put("mail.sntp.auth", "true");
          properties.put("mail.sntp.starttls.enable", "true");
           properties.put("mail.sntp.host", "sntp.gmail.com");
            properties.put("mail.sntp.port", "587");
            
            Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,pass);
            }
            });
            
            
            MimeMessage message = new MimeMessage(session);
            
            try {
                message.setFrom(new InternetAddress (from));
            } catch (MessagingException ex) {
                System.out.println("error in from");
            }
            try {
                message.addRecipient (Message.RecipientType.TO, new InternetAddress (to) ) ;
            } catch (MessagingException ex) {
               System.out.println("error in to ");
            }
            try {
                message. setSubject (subj) ;
            } catch (MessagingException ex) {
                System.out.println("error in subj");
            }
            try {
                message. setText (msg ) ;
            } catch (MessagingException ex) {
                System.out.println("error in msg");
            }
    
            
        try {
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            
            
            
}           
            
            
     }
      
  
    
    

