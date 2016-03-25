package tests;

import classes.Lewandowski;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class LevandowskiTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void shouldBeVoice() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertNotEquals(null, l.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals(null, l.attribute());
    }

    @Test
    public void positionShouldBeForward() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals("forward", l.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals(true, l.game_amount() > 5);
    }

    @Test
    public void goalsShouldBeOK() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals(true, l.goals() > 5);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals(true, l.yellow_cards() < 3);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Lewandowski l = ac.getBean(Lewandowski.class);
        Assert.assertEquals(true, l.red_cards() <= 1);
    }
}
