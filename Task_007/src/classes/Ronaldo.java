package classes;

import interfaces.Goal_celebration;
import interfaces.Kick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Ronaldo implements Goal_celebration{
    @Autowired
    @Qualifier("artem")
    public Dzuba dz;

    @Value("Cristiano")
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
