package Tests;

import classes.Drogba;
import classes.Dzuba;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_004
 */

public class DrogbaTest {
    public final static double eps = 1e-9;

    @Test
    public void shouldBeVoice() {
        Drogba d = new Drogba();
        Assert.assertNotEquals(null, d.voice());
    }

    @Test
    public void attributeShouldNotBeNull() {
        Drogba d = new Drogba();
        Assert.assertNotEquals(null, d.attribute());
    }

    @Test
    public void movingShouldNotBeNull() {
        Drogba d = new Drogba();
        Assert.assertNotEquals(null, d.move());
    }
}
