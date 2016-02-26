package classes;

public class Matrix2x2 {
    public double[][] mat = new double[2][2];

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double a, double b, double c, double d) {
        mat[0][0] = a;
        mat[0][1] = b;
        mat[1][0] = c;
        mat[1][1] = d;
    }

    public Matrix2x2(double ch) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat[j][i] = ch;
            }
        }
    }

    public Matrix2x2(double[][] mat2) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat[j][i] = mat2[j][i];
            }
        }
    }

    public String toString() {
        return (mat[0][0] + " " + mat[0][1] + "\n" + mat[1][0] + " " + mat[1][1]);
    }

    public Matrix2x2 add(Matrix2x2 mat3) {
        double[][] mat4 = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat4[j][i] = mat[j][i] + mat3.mat[j][i];
            }
        }
        return new Matrix2x2(mat4);
    }


    public void add2(Matrix2x2 mat2) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat[j][i] = mat[j][i] + mat2.mat[j][i];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 mat3) {
        double[][] mat4 = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat4[j][i] = mat[j][i] - mat3.mat[j][j];
            }
        }
        return new Matrix2x2(mat4);
    }

    public void sub2(Matrix2x2 mat2) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat[j][i] = mat[j][i] - mat2.mat[j][i];
            }
        }
    }

    public Matrix2x2 multNumber(double ch) {
        double[][] mat5 = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat5[j][i] = mat[j][i] * ch;
            }
        }

        return new Matrix2x2(mat5);
    }

    public void multNumber2(double ch1) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                mat[j][i] = mat[j][i] * ch1;
            }
        }

    }

    public double det() {
        return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];

    }

    public void transpon() {
        double f = mat[0][1];
        mat[0][1] = mat[1][0];
        mat[1][0] = f;
    }

    public Matrix2x2 inverseMatrix() {
        if (mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1] != 0) {
            mat[0][0] = mat[1][1] / (mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1]);
            mat[0][1] = -1 * mat[1][0] / (mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1]);
            mat[1][0] = -1 * mat[0][1] / (mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1]);
            mat[1][1] = mat[0][0] / (mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1]);
        }
        return new Matrix2x2(mat);
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 mat5 = new Matrix2x2(0,0,0,0);
        mat5.mat[1][0] = 0.0;
        mat5.mat[0][1] = 0.0;
        mat5.mat[0][0] = this.mat[0][0];
        mat5.mat[1][1] = this.mat[1][1];
        return mat5;
    }

    public Matrix2x2 mult(Matrix2x2 mat1) {
        return new Matrix2x2(mat[0][0] * mat1.mat[0][0] + mat[0][1] * mat1.mat[1][0],
                mat[0][0] * mat1.mat[0][1] + mat[0][1] * mat1.mat[1][1],
                mat[1][0] * mat1.mat[0][0] + mat[1][1] * mat1.mat[1][0],
                mat[1][0] * mat1.mat[0][1] + mat[1][1] * mat1.mat[1][1]);

    }

    public void mult2(Matrix2x2 mat2) {
        double a = mat[0][0];
        double b = mat[0][1];
        double c = mat[1][0];
        double d = mat[1][1];
        mat[0][0] = a * mat2.mat[0][0] + b * mat2.mat[1][0];
        mat[0][1] = a * mat2.mat[0][1] + b * mat2.mat[1][1];
        mat[1][0] = c * mat2.mat[0][0] + d * mat2.mat[1][0];
        mat[1][1] = c * mat2.mat[0][1] + d * mat2.mat[1][1];

    }

    public static void main(String[] args) {
        Matrix2x2 mat1 = new Matrix2x2(2.0,2.0,2.0,2.0);
        Matrix2x2 mat2 = new Matrix2x2(2.0,2.0,2.0,2.0);
        Matrix2x2 mat3 = new Matrix2x2(1.0,2.0,3.0,4.0);
        mat1.mult2(mat2);
        System.out.println(mat1);
        mat2.equivalentDiagonal();
        System.out.println();
        System.out.println(mat2);
        System.out.println();
        mat3.inverseMatrix();
        System.out.println(mat3);
    }
}
