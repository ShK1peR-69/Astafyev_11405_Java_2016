package classes;

import interfaces.Pass;
import interfaces.Running;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Marselo implements Running, Pass{
    @Value("Vieira")
    private String name;

    public Marselo() {
    }

    public Marselo(String name) {
        this.name = name;
    }

    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 52;
    }

    @Override
    public double accuracy() {
        return 0.94;
    }

    @Override
    public String running_type() {
        return "speedy and medium";
    }

    @Override
    public double max_speed() {
        return 31.3;
    }

    @Override
    public double all_distance() {
        return 10.0;
    }
}
