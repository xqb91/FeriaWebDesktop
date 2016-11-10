/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.tools;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author Victor Manuel Araya
 */
public class SendMail {
    
    private String username;
    private String password;
    private String destinatario;
    private String asunto;
    private String mensaje;

    public SendMail() {
        this.username = "";
        this.password = "";
        this.destinatario = "victor.araya92@gmail.com";
        this.asunto = "Correo Electrónico de Prueba de Feria Web Desktop";
        this.mensaje = "Este es un correo de prueba de Feria Web Desktop";
    }

    public SendMail(String destinatario, String asunto, String mensaje) {
        this.username = "";
        this.password = "";
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void enviar() {
     
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.macrolab.cl");
        props.put("mail.smtp.port", "26");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "El sistema ha enviado un correo electrónico a "+destinatario);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un problema en tiempo de ejecución: "+e.getMessage());
        }
    }
}
