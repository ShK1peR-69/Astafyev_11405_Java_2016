import classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

        Dibala dibala = ac.getBean(Dibala.class);
        dibala.accuracy();
        dibala.all_distance();
        dibala.amount();
        dibala.kick_accuracy();
        dibala.kick_amount();
        dibala.kick_power();
        dibala.kick_type();
        dibala.power();
        dibala.max_speed();
        dibala.running_type();

        Drogba didie = ac.getBean(Drogba.class);
        didie.attribute();
        didie.move();
        didie.voice();

        Dzuba artem = ac.getBean(Dzuba.class);
        artem.kick_type();
        artem.kick_power();
        artem.kick_amount();
        artem.kick_accuracy();

        Gerrard stiven = ac.getBean(Gerrard.class);
        stiven.max_speed();
        stiven.running_type();
        stiven.all_distance();

        Havi erni = ac.getBean(Havi.class);
        erni.power();
        erni.accuracy();
        erni.amount();

        Lewandowski lev =ac.getBean(Lewandowski.class);
        lev.voice();
        lev.move();
        lev.attribute();
        lev.game_amount();
        lev.goals();
        lev.position();
        lev.red_cards();
        lev.yellow_cards();

        Marselo maro =ac.getBean(Marselo.class);
        maro.all_distance();
        maro.amount();
        maro.accuracy();
        maro.running_type();
        maro.max_speed();
        maro.power();

        Terry john =ac.getBean(Terry.class);
        john.yellow_cards();
        john.red_cards();
        john.goals();
        john.position();
        john.game_amount();

        Messi leo =ac.getBean(Messi.class);
        leo.game_amount();
        leo.yellow_cards();
        leo.red_cards();
        leo.max_speed();
        leo.position();
        leo.accuracy();
        leo.amount();
        leo.power();
        leo.all_distance();
        leo.attribute();
        leo.goals();
        leo.kick_accuracy();
        leo.kick_amount();
        leo.kick_power();
        leo.kick_type();
        leo.voice();
        leo.running_type();


        Ronaldo cris = ac.getBean(Ronaldo.class);
        cris.move();
        cris.voice();
        cris.attribute();
    }
}
