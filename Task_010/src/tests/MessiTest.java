package tests;

import classes.Messi;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_010
 */

public class MessiTest {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void shouldBeVoice() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertNotEquals(null, m.voice());
    }

    @Test
    public void attributeShouldBeNull() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(null, m.attribute());
    }

    @Test
    public void movingShouldNotBeNull() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertNotEquals(null, m.move());
    }

    @Test
    public void kick_powerShouldBeStrong() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals("strong", m.kick_power());
    }

    @Test
    public void kick_amountShouldBeOK() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.kick_amount() >= 0);
    }

    @Test
    public void kick_accuracyShouldBeOK() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.kick_accuracy() >= 0);
    }

    @Test
    public void kick_typeShouldBeDifferent() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals("head and foot", m.kick_type());
    }

    @Test
    public void powerOfPassesShouldBeMedium() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals("medium", m.power());
    }

    @Test
    public void amountOfPassesShouldBeMany() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.amount() > 30);
    }

    @Test
    public void accuracyOfPassesShouldBeOK() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.accuracy() > 0.9);
    }


    @Test
    public void runningShouldNotBeFast() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.running_type().equals("speedy"));
    }

    @Test
    public void speedShouldBeFast() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.max_speed() > 32);
    }

    @Test
    public void distanceShouldBeNormal() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.all_distance() > 8);
    }

    @Test
    public void positionShouldBeForward() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals("forward", m.position());
    }

    @Test
    public void gamesShouldBeMany() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.game_amount() > 30);
    }

    @Test
    public void goalsShouldBeOK() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.goals() > 30);
    }

    @Test
    public void yellow_cardsShouldNotBeALot() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.yellow_cards() <= 3);
    }

    @Test
    public void red_cardsShouldNotBeALot() {
        Messi m = ac.getBean(Messi.class);
        Assert.assertEquals(true, m.red_cards() <= 1);
    }
}
