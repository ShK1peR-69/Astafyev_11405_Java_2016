package classes;

import interfaces.Goal_celebration;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Drogba implements Goal_celebration{
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
