package tests;

import classes.Dzuba;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class DzubaTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void kick_powerShouldBeStrong() {
        Dzuba d = ac.getBean(Dzuba.class);
        Assert.assertEquals("strong", d.kick_power());
    }

    @Test
    public void kick_amountShouldBeCorrect() {
        Dzuba d = ac.getBean(Dzuba.class);
        Assert.assertEquals(true, d.kick_amount() >= 0);
    }

    @Test
    public void kick_accuracyShouldBeCorrect() {
        Dzuba d = ac.getBean(Dzuba.class);
        Assert.assertEquals(true, d.kick_accuracy() >= 0);
    }

    @Test
    public void kick_typeShouldBeCorrect() {
        Dzuba d = ac.getBean(Dzuba.class);
        Assert.assertEquals("foot", d.kick_type());
    }
}
