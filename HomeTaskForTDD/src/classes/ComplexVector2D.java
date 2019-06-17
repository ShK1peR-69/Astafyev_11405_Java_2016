package classes;

public class ComplexVector2D {
    private ComplexNumber c;
    private ComplexNumber c1;

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());

    }

    public ComplexVector2D(ComplexNumber c, ComplexNumber c1) {
        this.c = c;
        this.c1 = c1;
    }

    public ComplexVector2D add(ComplexVector2D v) {

        return new ComplexVector2D(c.add(v.getC()), c1.add(v.getC1()));
    }

    public String toString() {

        return "(" + c.toString() + "; " + c1.toString() + ")";
    }

    public ComplexNumber scalarProduct(ComplexVector2D v) {

        return c.mult(v.getC()).add(c1.mult(v.getC1()));
    }

    public boolean equals(Object object) {
        ComplexVector2D v = (ComplexVector2D) object;
        return (c.equals(v.getC()) && c1.equals(v.getC1()));
    }


    public ComplexNumber getC() {
        return c;
    }

    public ComplexNumber getC1() {
        return c1;
    }

}

