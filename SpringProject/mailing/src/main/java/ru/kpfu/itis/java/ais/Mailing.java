package ru.kpfu.itis.java.ais;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailing {
    static final String username = "grigorich.poker@yandex.ru";
    static final String password = "njkrjdsq1ckjdfhm";

    /*
     *  Отправление e-mail для подтверждения регистрации
     */
    public static void sendApprovalMail(String name, String login, String email, String key) throws MessagingException {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress("grigorich.poker@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("SportParadiseShop");
            message.setText("Здравствуйте, " + name + "!\n" +
                    "\n" +
                    "Вы зарегистрировались на нашем сайте 'SportParadise'.\n" +
                    "Пожалуйста, подтвердите свою регистрацию, перейдя по ссылке:\n" +
                    "http://localhost:8080/registration/approval/" + login + "/" + key + "\n" +
                    "\n" +
                    "Спасибо! Удачных Вам покупок!\n" +
                    "Если это письмо пришло Вам случайно, пожалуйста, проигнорируйте его.");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new MessagingException(e.toString());
        }
    }

    public static Session getSession() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }
}