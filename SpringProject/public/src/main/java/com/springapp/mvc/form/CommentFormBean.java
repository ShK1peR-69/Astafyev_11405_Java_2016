package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

public class CommentFormBean {

    @NotEmpty(message = "Поле не может быть не заполненным")
    @Size(min=1, max=500, message="Сообщение должно содержать не более 200 символов")
    private String message;

    public CommentFormBean() {
    }

    public CommentFormBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommentFormBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
