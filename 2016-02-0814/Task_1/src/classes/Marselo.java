package classes;

import interfaces.Pass;
import interfaces.Running;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Marselo implements Running, Pass{
    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 52;
    }

    @Override
    public double accuracy() {
        return 0.94;
    }

    @Override
    public String running_type() {
        return "speedy and medium";
    }

    @Override
    public double max_speed() {
        return 31.3;
    }

    @Override
    public double all_distance() {
        return 10.0;
    }
}
