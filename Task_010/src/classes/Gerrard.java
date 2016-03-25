package classes;

import interfaces.Running;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Gerrard implements Running{
    @Value("Steven")
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
