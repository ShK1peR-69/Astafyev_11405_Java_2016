import classes.*;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Main {
    public static void main(String[] args) {
	
        Dibala dib = new Dibala();
        dib.accuracy();
        dib.all_distance();
        dib.amount();
        dib.kick_accuracy();
        dib.kick_amount();
        dib.kick_power();
        dib.kick_type();
        dib.power();
        dib.max_speed();
        dib.running_type();

        Drogba didie = new Drogba();
        didie.attribute();
        didie.move();
        didie.voice();

        Dzuba artem = new Dzuba();
        artem.kick_type();
        artem.kick_power();
        artem.kick_amount();
        artem.kick_accuracy();

        Gerrard stiven = new Gerrard();
        stiven.max_speed();
        stiven.running_type();
        stiven.all_distance();

        Havi erni = new Havi();
        erni.power();
        erni.accuracy();
        erni.amount();

        Levandowski lev = new Levandowski();
        lev.voice();
        lev.move();
        lev.attribute();
        lev.game_amount();
        lev.goals();
        lev.position();
        lev.red_cards();
        lev.yellow_cards();

        Marselo maro = new Marselo();
        maro.all_distance();
        maro.amount();
        maro.accuracy();
        maro.running_type();
        maro.max_speed();
        maro.power();

        Terry john = new Terry();
        john.yellow_cards();
        john.red_cards();
        john.goals();
        john.position();
        john.game_amount();

        Messi leo = new Messi();
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
        leo.move();
        leo.voice();
        leo.running_type();

        Ronaldo cris = new Ronaldo();
        cris.move();
        cris.voice();
        cris.attribute();
    }
}
