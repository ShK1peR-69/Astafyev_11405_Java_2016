package tests;

import classes.Havi;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class HaviTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void powerOfPassShouldBeMedium() {
        Havi h = ac.getBean(Havi.class);
        Assert.assertEquals("medium", h.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Havi h = ac.getBean(Havi.class);
        Assert.assertEquals(true, h.amount() > 40);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Havi h = ac.getBean(Havi.class);
        Assert.assertEquals(true, h.accuracy() > 0.9);
    }
}
