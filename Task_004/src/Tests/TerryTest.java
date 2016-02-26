package Tests;

import classes.Terry;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class TerryTest {
    public final static double eps = 1e-9;

    @Test
    public void positionShouldBeDefender() {
        Terry t = new Terry();
        Assert.assertEquals("defender", t.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Terry t = new Terry();
        Assert.assertEquals(true, t.game_amount() > 20);
    }

    @Test
    public void goalsShouldBeOK() {
        Terry t = new Terry();
        Assert.assertEquals(true, t.goals() > 5);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Terry t = new Terry();
        Assert.assertEquals(true, t.yellow_cards() <= 6);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Terry t = new Terry();
        Assert.assertEquals(true, t.red_cards() <= 2);
    }
}
