package classes;

import interfaces.Goal_celebration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Drogba implements Goal_celebration{
    @Value("Didie")
    private String name;

    public Drogba() {
    }

    public Drogba(String name) {
        this.name = name;
    }

    @Override
    public String voice() {
        return "Yyyeeaaah!";
    }

    @Override
    public String move() {
        return "running as the plane";
    }

    @Override
    public String attribute() {
        return  "bathing cap";
    }
}
