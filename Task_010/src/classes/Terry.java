package classes;

import interfaces.Overall_performance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class Terry implements Overall_performance{
    @Value("John")
    private String name;

    public Terry() {
    }

    public Terry(String name) {
        this.name = name;
    }

    @Override
    public String position() {
        return "defender";
    }

    @Override
    public int game_amount() {
        return 25;
    }

    @Override
    public int goals() {
        return 7;
    }

    @Override
    public int yellow_cards() {
        return 6;
    }

    @Override
    public int red_cards() {
        return 1;
    }
}
