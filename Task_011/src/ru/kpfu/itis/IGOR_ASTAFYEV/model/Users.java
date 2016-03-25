package ru.kpfu.itis.IGOR_ASTAFYEV.model;

public class Users {
    String login;
    String pass;
    int age;
    String mail;
    String sport;

    public Users(String login, String pass, int age, String mail, String sport) {
        this.login = login;
        this.pass = pass;
        this.age = age;
        this.mail = mail;
        this.sport = sport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
