package classes;

import interfaces.Goal_celebration;
import interfaces.Overall_performance;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Lewandowski implements Goal_celebration, Overall_performance{
    private String name;

    public Lewandowski() {
    }

    public Lewandowski(String name) {
        this.name = name;
    }

    @Override
    public String voice() {
        return "Goooool!!!";
    }

    @Override
    public String move() {
        return "quick run";
    }

    @Override
    public String attribute() {
        return null;
    }

    @Override
    public String position() {
        return "forward";
    }

    @Override
    public int game_amount() {
        return 9;
    }

    @Override
    public int goals() {
        return 11;
    }

    @Override
    public int yellow_cards() {
        return 1;
    }

    @Override
    public int red_cards() {
        return 0;
    }
}
