package Tests;

import classes.Havi;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class HaviTest {
    public final static double eps = 1e-9;

    @Test
    public void powerOfPassShouldBeMedium() {
        Havi h = new Havi();
        Assert.assertEquals("medium", h.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Havi h = new Havi();
        Assert.assertEquals(true, h.amount() > 40);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Havi h = new Havi();
        Assert.assertEquals(true, h.accuracy() > 0.9);
    }
}
