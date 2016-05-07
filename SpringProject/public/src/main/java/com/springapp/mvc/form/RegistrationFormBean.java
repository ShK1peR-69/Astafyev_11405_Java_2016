package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

public class RegistrationFormBean {

    @Pattern(regexp="([А-ЯЁ][а-яё]+[\\-\\s]?){3}",
            message="Неверно введены данные. Пример: Иванов Сергей Петрович")
    private String fio;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String login;

    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;

    @Size(min=4, max=20, message="Пароль должен содержать от 4 до 20 символов")
    private String password_one;

    @Size(min=4, max=20, message="Пароль должен содержать от 4 до 20 символов")
    private String password_two;

    public RegistrationFormBean() {
    }

    public RegistrationFormBean(String fio, String login, String email, String password_one, String password_two) {
        this.fio = fio;
        this.login = login;
        this.email = email;
        this.password_one = password_one;
        this.password_two = password_two;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public String getPassword_one() {
        return password_one;
    }

    public void setPassword_one(String password_one) {
        this.password_one = password_one;
    }

    public String getPassword_two() {
        return password_two;
    }

    public void setPassword_two(String password_two) {
        this.password_two = password_two;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "fio='" + fio + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password_one='" + password_one + '\'' +
                ", password_two='" + password_two + '\'' +
                '}';
    }
}
