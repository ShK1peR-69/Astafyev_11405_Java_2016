import classes.Matrix2x2;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_002
 */

public class Task_002 {
    public final static double eps = 1e-9;

    @Test
    public void ElementsInMatrixShouldNotBeNull() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 1.0, 1.0, 1.0);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertNotEquals(null, mat1.mat[i][j], eps);
            }
        }
    }

    @Test
    public void allElementsShouldBeEquals() {
        Matrix2x2 mat2 = new Matrix2x2(1.0, 1.0, 1.0, 1.0);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(1.0, mat2.mat[i][j], eps);
            }
        }
    }

    @Test
    public void sumShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        Matrix2x2 mat2 = new Matrix2x2(4.0, 3.0, 2.0, 1.0);
        Matrix2x2 mat3 = mat1.add(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(5.0, mat3.mat[i][j], eps);
            }
        }
    }

    @Test
    public void sum2ShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        Matrix2x2 mat2 = new Matrix2x2(4.0, 3.0, 2.0, 1.0);
        mat1.add2(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(5.0, mat1.mat[i][j], eps);
            }
        }
    }

    @Test
    public void subShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(5.0, 4.0, 3.0, 2.0);
        Matrix2x2 mat2 = new Matrix2x2(4.0, 3.0, 2.0, 1.0);
        mat1.sub2(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(1.0, mat1.mat[i][j], eps);
            }
        }
    }

    @Test
    public void sub2ShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(5.0, 5.0, 5.0, 5.0);
        Matrix2x2 mat2 = new Matrix2x2(0.0, 0.0, 0.0, 0.0);
        Matrix2x2 mat3 = mat1.sub(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(5.0, mat3.mat[i][j], eps);
            }
        }
    }

    @Test
    public void multOnNumberShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 1.0, 1.0, 1.0);
        Matrix2x2 mat2 = mat1.multNumber(3);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(3.0, mat2.mat[i][j], eps);
            }
        }
    }

    @Test
    public void mult2OnNumberShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 1.0, 1.0, 1.0);
        mat1.multNumber2(2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(2.0, mat1.mat[i][j], eps);
            }
        }
    }

    @Test
    public void transponShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        double a = 0;
        double b = 0;
        mat1.transpon();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a = mat1.mat[0][1];
                b = mat1.mat[1][0];
            }
        }
        Assert.assertEquals(3.0, a, eps);
        Assert.assertEquals(2.0, b, eps);
    }

    @Test
    public void detShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        double deter = mat1.det();
        Assert.assertEquals(-2.0, deter, eps);
    }

    @Test
    public void multShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 1.0, 1.0, 1.0);
        Matrix2x2 mat2 = new Matrix2x2(2.0, 2.0, 2.0, 2.0);
        Matrix2x2 mat3 = mat1.mult(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(4.0, mat3.mat[i][j], eps);
            }
        }
    }

    @Test
    public void mult2ShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(2.0, 2.0, 2.0, 2.0);
        Matrix2x2 mat2 = new Matrix2x2(3.0, 3.0, 3.0, 3.0);
        mat1.mult2(mat2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(12.0, mat1.mat[i][j], eps);
            }
        }
    }

    @Ignore
    @Test
    public void equivalentDiagonalMatrixShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        mat1.equivalentDiagonal();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a = mat1.mat[0][0];
                b = mat1.mat[0][1];
                c = mat1.mat[1][0];
                d = mat1.mat[1][1];
            }
        }
        Assert.assertEquals(1, a, eps);
        Assert.assertEquals(0, b, eps);
        Assert.assertEquals(0, c, eps);
        Assert.assertEquals(4, d, eps);
    }

    @Ignore
    @Test
    public void inverseOfMatrixShouldBeCorrect() {
        Matrix2x2 mat1 = new Matrix2x2(1.0, 2.0, 3.0, 4.0);
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        mat1.inverseMatrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a = mat1.mat[0][0];
                b = mat1.mat[0][1];
                c = mat1.mat[1][0];
                d = mat1.mat[1][1];
            }
        }
        Assert.assertEquals(-2, a, eps);
        Assert.assertEquals(1.5, b, eps);
        Assert.assertEquals(1, c, eps);
        Assert.assertEquals(-0.5, d, eps);
    }

}
