package Tests;

import classes.Ronaldo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class RonaldoTest {
    public final static double eps = 1e-9;

    @Test
    public void shouldBeVoice() {
        Ronaldo r = new Ronaldo();
        Assert.assertNotEquals(null, r.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Ronaldo r = new Ronaldo();
        Assert.assertEquals(null, r.attribute());
    }

    @Test
    public void movingShouldNotBeJumping() {
        Ronaldo r = new Ronaldo();
        Assert.assertEquals("jumping", r.move());
    }
}
