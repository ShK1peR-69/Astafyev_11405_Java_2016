package Tests;

import classes.Messi;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class MessiTest {
    public final static double eps = 1e-9;

    @Test
    public void shouldBeVoice() {
        Messi m = new Messi();
        Assert.assertNotEquals(null, m.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Messi m = new Messi();
        Assert.assertEquals(null, m.attribute());
    }

    @Test
    public void movingShouldNotBeNull() {
        Messi m = new Messi();
        Assert.assertNotEquals(null, m.move());
    }

    @Test
    public void kick_powerShouldBeStrong() {
        Messi m = new Messi();
        Assert.assertEquals("strong", m.kick_power());
    }

    @Test
    public void kick_amountShouldBeOK() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.kick_amount() >= 0);
    }

    @Test
    public void kick_accuracyShouldBeOK() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.kick_accuracy() >= 0);
    }

    @Test
    public void kick_typeShouldBeDifferent() {
        Messi m = new Messi();
        Assert.assertEquals("head and foot", m.kick_type());
    }

    @Test
    public void powerOfPassesShouldBeMedium() {
        Messi m = new Messi();
        Assert.assertEquals("medium", m.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.amount() > 30);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.accuracy() > 0.9);
    }


    @Test
    public void runningShouldNotBeFast() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.running_type().equals("speedy"));
    }

    @Test
    public void speedShouldBeFast() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.all_distance() > 8);
    }

    @Test
    public void positionShouldBeForward() {
        Messi m = new Messi();
        Assert.assertEquals("forward", m.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.game_amount() > 30);
    }

    @Test
    public void goalsShouldBeOK() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.goals() > 30);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.yellow_cards() <= 3);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Messi m = new Messi();
        Assert.assertEquals(true, m.red_cards() <= 1);
    }
}
