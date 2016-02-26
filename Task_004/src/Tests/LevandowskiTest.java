package Tests;

import classes.Levandowski;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class LevandowskiTest {
    public final static double eps = 1e-9;

    @Test
    public void shouldBeVoice() {
        Levandowski l = new Levandowski();
        Assert.assertNotEquals(null, l.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Levandowski l = new Levandowski();
        Assert.assertEquals(null, l.attribute());
    }

    @Test
    public void positionShouldBeForward() {
        Levandowski l = new Levandowski();
        Assert.assertEquals("forward", l.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Levandowski l = new Levandowski();
        Assert.assertEquals(true, l.game_amount() > 5);
    }

    @Test
    public void goalsShouldBeOK() {
        Levandowski l = new Levandowski();
        Assert.assertEquals(true, l.goals() > 5);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Levandowski l = new Levandowski();
        Assert.assertEquals(true, l.yellow_cards() < 3);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Levandowski l = new Levandowski();
        Assert.assertEquals(true, l.red_cards() <= 1);
    }
}
