package ru.kpfu.itis.java2k.ais;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Developer {

    public String getName() {
        return name;
    }

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println("I am working at Saturday.");
    }

    public void learnLanguage(String language) {
        System.out.println("I am learning language " + language);
    }
}