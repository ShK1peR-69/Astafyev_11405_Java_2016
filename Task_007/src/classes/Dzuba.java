package classes;

import interfaces.Kick;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
@Qualifier("artem")
public class Dzuba implements Kick{
    @Value("Artem")
    private String name;

    public Dzuba() {
    }

    public Dzuba(String name) {
        this.name = name;
    }

    @Override
    public String kick_power() {
        return "strong";
    }

    @Override
    public int kick_amount() {
        return 3;
    }

    @Override
    public double kick_accuracy() {
        return 0.33;
    }

    @Override
    public String kick_type() {
        return "foot";
    }
}
