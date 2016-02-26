package Tests;

import classes.Gerrard;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class GerrardTest {
    public final static double eps = 1e-9;

    @Test
    public void runningShouldBeFast() {
        Gerrard g = new Gerrard();
        Assert.assertEquals("speedy", g.running_type());
    }

    @Test
    public void speedShouldBeNotFast() {
        Gerrard g = new Gerrard();
        Assert.assertEquals(false, g.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Gerrard g = new Gerrard();
        Assert.assertEquals(true, g.all_distance() > 8);
    }
}
