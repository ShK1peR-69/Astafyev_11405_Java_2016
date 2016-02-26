package Tests;

import classes.Dzuba;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class DzubaTest {
    public final static double eps = 1e-9;

    @Test
    public void kick_powerShouldBeStrong() {
        Dzuba d = new Dzuba();
        Assert.assertEquals("strong", d.kick_power());
    }

    @Test
    public void kick_amountShouldBeCorrect() {
        Dzuba d = new Dzuba();
        Assert.assertEquals(true, d.kick_amount() >= 0);
    }

    @Test
    public void kick_accuracyShouldBeCorrect() {
        Dzuba d = new Dzuba();
        Assert.assertEquals(true, d.kick_accuracy() >= 0);
    }

    @Test
    public void kick_typeShouldBeCorrect() {
        Dzuba d = new Dzuba();
        Assert.assertEquals("foot", d.kick_type());
    }
}
