package com.my.blog.api_myblog.Services.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationSenEmail {
    private final JavaMailSender mailSender;

    @Value("${support.mail}")
    private String supportEmail;

    public NotificationSenEmail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void SendEmailPaymentCongratulations(String nomeProject, String description, String createdAt) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mail, true, "UTF-8");
            messageHelper.setSubject("Blog | Projeto upado com sucesso");
            messageHelper.setText(getMessageMail(nomeProject, description, createdAt), true);
            messageHelper.setFrom(supportEmail);
            messageHelper.setTo(supportEmail);
            mailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getMessageMail(String nomeProject, String description, String createdAt) {
        

        return "<!DOCTYPE html>" +
               "<html lang='pt-BR'>" +
               "<head>" +
               "<meta charset='UTF-8'>" +
               "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
               "<style>" +
               "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
               ".email-container { background-color: #ffffff; margin: 20px; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
               ".header { background-color: #4CAF50; padding: 10px; color: white; text-align: center; border-radius: 10px 10px 0 0; }" +
               ".content { padding: 20px; }" +
               ".footer { text-align: center; padding: 10px; font-size: 12px; color: #888888; }" +
               "</style>" +
               "</head>" +
               "<body>" +
               "<div class='email-container'>" +
               "<div class='header'>" +
               "<h1>Parabéns!</h1>" +
               "</div>" +
               "<div class='content'>" +
               "<p>Olá,</p>" +
               "<p>O projeto <strong>" + nomeProject + "</strong> foi adicionado com sucesso ao blog.</p>" +
               "<p><strong>Descrição:</strong> " + description + "</p>" +
               "<p><strong>Data de Criação:</strong> " + createdAt+ "</p>" +
               "<p>Você pode ver mais detalhes sobre o projeto <a href='https://blog-frontend-weld-three.vercel.app/'>aqui</a>.</p>" +
               "</div>" +
               "<div class='footer'>" +
               "<p>&copy; 2024 Blog. Todos os direitos reservados.</p>" +
               "</div>" +
               "</div>" +
               "</body>" +
               "</html>";
    }
}
