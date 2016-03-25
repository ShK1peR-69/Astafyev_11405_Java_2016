package classes;

import interfaces.Goal_celebration;
import interfaces.Kick;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Ronaldo implements Goal_celebration{
    public Dzuba dz;
    private String name;

    public Ronaldo() {
    }

    public Ronaldo(String name) {
        this.name = name;
    }

    @Override
    public String voice() {
        return "Aaaaaaa!";
    }

    @Override
    public String move() {
        return "jumping";
    }

    @Override
    public String attribute() {
        return null;
    }

}
