import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.java2k.ais.ITStudent;
import ru.kpfu.itis.java2k.ais.Institute;
import ru.kpfu.itis.java2k.ais.Student;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.itis.java2k.ais"})
public class JavaConfig {

    @Autowired
    @Qualifier("it")
    Institute institute;

    @Bean
    public Student itStudent100500() {
        ITStudent st = new ITStudent();
        return st;
    }

}