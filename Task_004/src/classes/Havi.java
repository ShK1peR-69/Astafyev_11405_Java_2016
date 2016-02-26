package classes;

import interfaces.Pass;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Havi implements Pass {
    @Override
    public String power() {
        return "medium";
    }

    @Override
    public int amount() {
        return 42;
    }

    @Override
    public double accuracy() {
        return 0.91;
    }
}
