import classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Astafyev Igor
 *         11-405
 */


@Configuration
@ComponentScan(basePackages = {"classes"})
public class JavaConfig {

    @Bean
    public Dibala dibala() {
        return new Dibala();
    }

    @Bean
    public Havi havi() {
        return new Havi();
    }

    @Bean
    public Ronaldo ronaldo() {
        return new Ronaldo();
    }

    @Bean
    public Messi messi() {
        return new Messi();
    }

    @Bean
    public Drogba drogba() {
        return new Drogba();
    }

    @Bean
    public Dzuba dzuba() {
        return new Dzuba();
    }

    @Bean
    public Terry terry() {
        return new Terry();
    }

    @Bean
    public Gerrard gerrard() {
        return new Gerrard();
    }

    @Bean
    public Marselo marselo() {
        return new Marselo();
    }

    @Bean
    public Lewandowski lewandowski() {
        return new Lewandowski();
    }
}
