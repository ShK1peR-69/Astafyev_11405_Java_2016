import classes.ComplexMatrix2x2;
import classes.ComplexNumber;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_009
 */

public class Task_003 {
    public final static double eps = 1e-9;
    ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    @Test
    public void constructorForZeroMatrixShouldBeCorrect() {
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(ac.getBean(ComplexNumber.class), cm1.c[i][j]);
            }
        }
    }

    @Test
    public void constructorShouldNotBeNull() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        cm1.setA01(cn2);
        cm1.setA10(cn3);
        cm1.setA11(cn4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertNotEquals(null, cm1.c[i][j], eps);
            }
        }
    }

    @Test
    public void allElementsShouldBeEquals() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);

        ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cn1, cm1.c[i][j]);
            }
        }
    }

    @Test
    public void allElementsShouldBeDifferent() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        cm1.setA01(cn2);
        cm1.setA10(cn3);
        cm1.setA11(cn4);
        Assert.assertEquals(cn1, cm1.getA00());
        Assert.assertEquals(cn2, cm1.getA01());
        Assert.assertEquals(cn3, cm1.getA10());
        Assert.assertEquals(cn4, cm1.getA11());
    }

    @Test
    public void sumOfMatrixShouldBeCorrect() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        cm1.setA01(cn2);
        cm1.setA10(cn3);
        cm1.setA11(cn4);
        ComplexMatrix2x2 cm2 = ac.getBean(ComplexMatrix2x2.class);
        cm2.setA00(cn4);
        cm2.setA01(cn3);
        cm2.setA10(cn2);
        cm2.setA11(cn1);
        ComplexMatrix2x2 cm3 = cm1.add(cm2);
        Assert.assertEquals(cm3.getA00(), cn1.add(cn4));
        Assert.assertEquals(cm3.getA01(), cn2.add(cn3));
        Assert.assertEquals(cm3.getA10(), cn3.add(cn2));
        Assert.assertEquals(cm3.getA11(), cn4.add(cn1));
    }

    @Test(expected = NullPointerException.class)
    public void multOfMatrixShouldBeCorrect() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        cm1.setA01(cn2);
        ComplexMatrix2x2 cm2 = ac.getBean(ComplexMatrix2x2.class);
        cm2.setA00(cn2);
        cm2.setA01(cn1);
        ComplexMatrix2x2 cm3 = cm1.mult(cm2);
        Assert.assertEquals(cm3.getA00(), cn1.mult(cn2).add(cn1.mult(cn2)));
        Assert.assertEquals(cm3.getA01(), cn1.mult(cn2).add(cn1.mult(cn2)));
        Assert.assertEquals(cm3.getA10(), cn1.mult(cn2).add(cn1.mult(cn2)));
        Assert.assertEquals(cm3.getA11(), cn1.mult(cn2).add(cn1.mult(cn2)));
    }

    @Test(expected = NullPointerException.class)
    public void deterOfMatrixShouldBeCorrect() {
        ComplexNumber cn1 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean(ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean(ComplexNumber.class);
        ComplexMatrix2x2 cm1 = ac.getBean(ComplexMatrix2x2.class);
        cm1.setA00(cn1);
        cm1.setA01(cn2);
        cm1.setA10(cn3);
        cm1.setA11(cn4);
        ComplexNumber deter = cm1.det();
        Assert.assertEquals(deter, cn1.mult(cn4).sub(cn3.mult(cn2)));
    }
}
