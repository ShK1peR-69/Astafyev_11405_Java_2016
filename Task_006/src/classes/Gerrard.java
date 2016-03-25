package classes;

import interfaces.Running;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Gerrard implements Running{
    private String name;

    public Gerrard() {
    }

    public Gerrard(String name) {
        this.name = name;
    }

    @Override
    public String running_type() {
        return "speedy";
    }

    @Override
    public double max_speed() {
        return 31.9;
    }

    @Override
    public double all_distance() {
        return 10.3;
    }
}
