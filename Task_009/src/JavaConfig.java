import classes.ComplexMatrix2x2;
import classes.ComplexNumber;
import classes.ComplexVector2D;
import classes.Matrix2x2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Configuration
@ComponentScan(basePackages = "classes")
public class JavaConfig {

    @Bean
    public ComplexMatrix2x2 complexMatrix2x2() {
        return new ComplexMatrix2x2();
    }

    @Bean
    public ComplexNumber complexNumber() {
        return new ComplexNumber();
    }

    @Bean
    public ComplexVector2D complexVector2D() {
        return new ComplexVector2D();
    }

    @Bean
    public Matrix2x2 matrix2x2() {
        return new Matrix2x2();
    }

}