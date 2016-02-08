package classes;

import interfaces.Kick;
import interfaces.Pass;
import interfaces.Running;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Dibala implements Running, Kick, Pass{

    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 39;
    }

    @Override
    public double accuracy() {
        return 0.83;
    }

    @Override
    public String running_type() {
        return "light";
    }

    @Override
    public double max_speed() {
        return 33.5;
    }

    @Override
    public double all_distance() {
        return 9.8;
    }

    @Override
    public String kick_power() {
        return "strong";
    }

    @Override
    public int kick_amount() {
        return 1;
    }

    @Override
    public double kick_accuracy() {
        return 0;
    }

    @Override
    public String kick_type() {
        return "head";
    }
}
