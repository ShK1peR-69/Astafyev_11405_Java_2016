package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class FeedbackFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String login;

    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String subject;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min=1, max=500, message="Сообщение должно содержать не более 500 символов")
    private String message;

    public FeedbackFormBean() {
    }

    public FeedbackFormBean(String login, String email, String subject, String message) {
        this.login = login;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FeedbackFormBean{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
