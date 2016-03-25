package tests;

import classes.Ronaldo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class RonaldoTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void shouldBeVoice() {
        Ronaldo r = ac.getBean(Ronaldo.class);
        Assert.assertNotEquals(null, r.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Ronaldo r = ac.getBean(Ronaldo.class);
        Assert.assertEquals(null, r.attribute());
    }

    @Test
    public void movingShouldNotBeJumping() {
        Ronaldo r = ac.getBean(Ronaldo.class);
        Assert.assertEquals("jumping", r.move());
    }
}
