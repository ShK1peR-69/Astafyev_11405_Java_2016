package tests;

import classes.Marselo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class MarseloTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);


    @Test
    public void powerShouldBeMedium() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals("medium", m.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals(true, m.amount() > 40);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals(true, m.accuracy() > 0.9);
    }

    @Test
    public void runningShouldNotBeLight() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals(false, m.running_type().equals("light"));
    }

    @Test
    public void speedShouldBeNotFast() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals(false, m.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Marselo m = ac.getBean(Marselo.class);
        Assert.assertEquals(true, m.all_distance() > 8);
    }
}
