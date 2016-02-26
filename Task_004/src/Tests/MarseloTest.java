package Tests;

import classes.Marselo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class MarseloTest {
    public final static double eps = 1e-9;


    @Test
    public void powerShouldBeMedium() {
        Marselo m = new Marselo();
        Assert.assertEquals("medium", m.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Marselo m = new Marselo();
        Assert.assertEquals(true, m.amount() > 40);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Marselo m = new Marselo();
        Assert.assertEquals(true, m.accuracy() > 0.9);
    }

    @Test
    public void runningShouldNotBeLight() {
        Marselo m = new Marselo();
        Assert.assertEquals(false, m.running_type().equals("light"));
    }

    @Test
    public void speedShouldBeNotFast() {
        Marselo m = new Marselo();
        Assert.assertEquals(false, m.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Marselo m = new Marselo();
        Assert.assertEquals(true, m.all_distance() > 8);
    }
}
