package classes;

import org.springframework.stereotype.Component;

@Component
public class ComplexMatrix2x2 {
    public ComplexNumber c[][] = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber c) {
        this(c, c, c, c);
    }

    public ComplexMatrix2x2(ComplexNumber a00, ComplexNumber a01, ComplexNumber a10, ComplexNumber a11) {
        c[0][0] = a00;
        c[0][1] = a01;
        c[1][0] = a10;
        c[1][1] = a11;
    }

    public void setC(ComplexNumber[][] c) {
        this.c = c;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 m) {
        return new ComplexMatrix2x2(c[0][0].add(m.getA00()), c[0][1].add(m.getA01()),
                c[1][0].add(m.getA10()), c[1][1].add(m.getA11()));
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 m) {
        return new ComplexMatrix2x2(
                c[0][0].mult(m.getA00()).add(c[0][1].mult(m.getA10())),
                c[0][0].mult(m.getA01()).add(c[0][1].mult(m.getA11())),
                c[1][0].mult(m.getA00()).add(c[1][1].mult(m.getA10())),
                c[1][0].mult(m.getA01()).add(c[1][1].mult(m.getA11())));
    }

    public ComplexNumber det() {
        ComplexNumber mult = c[0][0].mult(c[1][1]);
        ComplexNumber mult1 = c[0][1].mult(c[1][0]);
        return mult.sub(mult1);
    }

    public ComplexVector2D multVector(ComplexVector2D v) {
        return new ComplexVector2D(c[0][0].mult(v.getC()).add(c[0][1].mult(v.getC())), c[1][0].mult(v.getC1()).add(c[1][1]).mult(v.getC1()));
    }

    public String toString() {
        return c[0][0].toString() + ", " + c[0][1].toString() + ", " + c[1][0].toString() + ", " + c[1][1].toString();
    }

    public boolean equals(Object obj) {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) obj;
        return c[0][0].equals(cm.getA00()) && c[0][1].equals(cm.getA01()) && c[1][0].equals(cm.getA10()) && c[1][1].equals(cm.getA11());
    }

    public ComplexNumber getA00() {
        return c[0][0];
    }

    public ComplexNumber getA01() {
        return c[0][1];
    }

    public ComplexNumber getA10() {
        return c[1][0];
    }

    public ComplexNumber getA11() {
        return c[1][1];
    }

    public void setA00(ComplexNumber cn00) {
        this.c[0][0] = cn00;
    }

    public void setA01(ComplexNumber cn01) {
        this.c[0][1] = cn01;
    }

    public void setA10(ComplexNumber cn10) {
        this.c[1][0] = cn10;
    }

    public void setA11(ComplexNumber cn11) {
        this.c[1][1] = cn11;
    }
}
