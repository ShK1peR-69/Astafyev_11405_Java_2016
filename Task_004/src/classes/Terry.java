package classes;

import interfaces.Overall_performance;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Terry implements Overall_performance{
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
