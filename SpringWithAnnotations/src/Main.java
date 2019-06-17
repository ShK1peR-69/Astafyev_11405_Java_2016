import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.java2k.ais.BioStudent;
import ru.kpfu.itis.java2k.ais.ITStudent;
import ru.kpfu.itis.java2k.ais.Student;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student stBio = ac.getBean(BioStudent.class);
        Student stIT = ac.getBean(ITStudent.class);
        Student st = (Student) ac.getBean("ITStudent");
        System.out.println(stIT);
        System.out.println(stBio);
    }
}