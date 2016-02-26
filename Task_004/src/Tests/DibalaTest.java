package Tests;

import classes.Dibala;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class DibalaTest {
    public final static double eps = 1e-9;

    @Test
    public void powerShouldBeMedium() {
        Dibala d = new Dibala();
        Assert.assertEquals("medium", d.power());
    }

    @Test
    public void accuracyShouldBeCorrect() {
        Dibala d = new Dibala();
        Assert.assertEquals(true, d.accuracy() >= 0);
    }

    @Test
    public void runningShouldBeLight() {
        Dibala d = new Dibala();
        Assert.assertEquals("light", d.running_type());
    }

    @Test
    public void speedShouldBeFast() {
        Dibala d = new Dibala();
        Assert.assertEquals(true, d.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Dibala d = new Dibala();
        Assert.assertEquals(true, d.all_distance() > 8);
    }

    @Test
    public void kickShouldBeStrong() {
        Dibala d = new Dibala();
        Assert.assertEquals("strong", d.kick_power());
    }

    @Test
    public void kick_amountShouldBeRight() {
        Dibala d = new Dibala();
        Assert.assertEquals(true, d.kick_amount() >= 0);
    }

    @Test
    public void kick_accuracyShouldBeCorrect() {
        Dibala d = new Dibala();
        Assert.assertEquals(true, d.kick_accuracy() >= 0);
    }

    @Test
    public void kick_typeShouldBeCorrect() {
        Dibala d = new Dibala();
        Assert.assertEquals("head", d.kick_type());
    }
}
