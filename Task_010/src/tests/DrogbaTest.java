package tests;

import classes.Drogba;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class DrogbaTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void shouldBeVoice() {
        Drogba d = ac.getBean(Drogba.class);
        Assert.assertNotEquals(null, d.voice());
    }

    @Test
    public void attributeShouldNotBeNull() {
        Drogba d = ac.getBean(Drogba.class);
        Assert.assertNotEquals(null, d.attribute());
    }

    @Test
    public void movingShouldNotBeNull() {
        Drogba d = ac.getBean(Drogba.class);
        Assert.assertNotEquals(null, d.move());
    }
}
