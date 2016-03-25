package tests;

import classes.Terry;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class TerryTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void positionShouldBeDefender() {
        Terry t = ac.getBean(Terry.class);
        Assert.assertEquals("defender", t.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Terry t = ac.getBean(Terry.class);
        Assert.assertEquals(true, t.game_amount() > 20);
    }

    @Test
    public void goalsShouldBeOK() {
        Terry t = ac.getBean(Terry.class);
        Assert.assertEquals(true, t.goals() > 5);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Terry t = ac.getBean(Terry.class);
        Assert.assertEquals(true, t.yellow_cards() <= 6);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Terry t = ac.getBean(Terry.class);
        Assert.assertEquals(true, t.red_cards() <= 2);
    }
}
