package classes;

import interfaces.Kick;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Dzuba implements Kick{
    @Override
    public String kick_power() {
        return "strong";
    }

    @Override
    public int kick_amount() {
        return 3;
    }

    @Override
    public double kick_accuracy() {
        return 0.33;
    }

    @Override
    public String kick_type() {
        return "foot";
    }
}
