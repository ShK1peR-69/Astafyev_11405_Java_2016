package classes;

import interfaces.Goal_celebration;
import interfaces.Kick;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Ronaldo implements Goal_celebration{
    public Dzuba dz;

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
