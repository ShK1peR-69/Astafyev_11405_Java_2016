package classes;

import interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Messi implements Goal_celebration, Kick, Pass, Running, Overall_performance{
    @Autowired
    @Qualifier("rob")
    public Lewandowski leva;

    @Value("Lionel")
    private String name;

    public Messi() {
    }

    public Messi(String name) {
        this.name = name;
    }

    @Override
    public String voice() {
        return "Gooaaal!!!";
    }

    @Override
    public String move() {
        return "sliding on knees";
    }

    @Override
    public String attribute() {
        return null;
    }

    @Override
    public String kick_power() {
        return "strong";
    }

    @Override
    public int kick_amount() {
        return 7;
    }

    @Override
    public double kick_accuracy() {
        return 0.83;
    }

    @Override
    public String kick_type() {
        return "head and foot";
    }

    @Override
    public String position() {
        return "forward";
    }

    @Override
    public int game_amount() {
        return 52;
    }

    @Override
    public int goals() {
        return 57;
    }

    @Override
    public int yellow_cards() {
        return 3;
    }

    @Override
    public int red_cards() {
        return 0;
    }

    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 37;
    }

    @Override
    public double accuracy() {
        return 0.96;
    }

    @Override
    public String running_type() {
        return "speedy";
    }

    @Override
    public double max_speed() {
        return 35.7;
    }

    @Override
    public double all_distance() {
        return 9.78;
    }
}
