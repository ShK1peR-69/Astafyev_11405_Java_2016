package tests;

import classes.Gerrard;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class GerrardTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void runningShouldBeFast() {
        Gerrard g = ac.getBean(Gerrard.class);
        Assert.assertEquals("speedy", g.running_type());
    }

    @Test
    public void speedShouldBeNotFast() {
        Gerrard g = ac.getBean(Gerrard.class);
        Assert.assertEquals(false, g.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Gerrard g = ac.getBean(Gerrard.class);
        Assert.assertEquals(true, g.all_distance() > 8);
    }
}
