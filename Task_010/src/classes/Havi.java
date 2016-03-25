package classes;

import interfaces.Pass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Havi implements Pass {
    @Value("Ernandes")
    private String name;

    public Havi() {
    }

    public Havi(String name) {
        this.name = name;
    }

    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 42;
    }

    @Override
    public double accuracy() {
        return 0.91;
    }
}
