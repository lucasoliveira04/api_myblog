package com.my.blog.api_myblog.Services.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;

public class NotificationEmail {
    private final JavaMailSender javaMailSender;
    private final JavaMailSenderImpl javaMailSenderImpl;
    
    public NotificationEmail(JavaMailSender javaMailSender, JavaMailSenderImpl javaMailSenderImpl) {
        this.javaMailSender = javaMailSender;
        this.javaMailSenderImpl = javaMailSenderImpl;
    }

    @Value("${support.mail}")
    private String supportMail;

     public void sendMail() {
        try{
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mail);
            messageHelper.setSubject("Projeto adicionado ao Blog");
            messageHelper.setText(getMessageMail(), true);
            messageHelper.setFrom(supportMail);
            messageHelper.setTo(supportMail);
            javaMailSenderImpl.send(mail);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getMessageMail() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Client Email Template</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #333;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #fff;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        h2 {\n" +
                "            color: #007bff;\n" +
                "        }\n" +
                "        p {\n" +
                "            margin-bottom: 15px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h2>Olá Olá Lucas, um novo projeto foi adicionado ao seu blog.</h2>\n" +
                "        <p>Login realizado com sucesso.</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
