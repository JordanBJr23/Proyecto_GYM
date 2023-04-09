package modelo;

import java.io.File;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {

    public static void enviarCorreo(File correo, String destino) {
        final String de = "sjjgym@gmail.com";
        final String contraseña = "apzfczpccnhanlkj";
        final String asunto = "Bienvenido a la familia";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.localhost", "localhost");
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session sesion = Session.getInstance(p,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(de, contraseña);
            }
        });
        try {
            MimeMessage mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(de));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asunto);

            MimeBodyPart archivoAdjunto = new MimeBodyPart();
            archivoAdjunto.attachFile(correo);

            Multipart contenidoDelMensaje = new MimeMultipart();
            contenidoDelMensaje.addBodyPart(archivoAdjunto);

            mensaje.setContent(contenidoDelMensaje);

            Transport.send(mensaje);
            JOptionPane.showMessageDialog(null, "Los datos fueron enviados al correo: " + destino);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
