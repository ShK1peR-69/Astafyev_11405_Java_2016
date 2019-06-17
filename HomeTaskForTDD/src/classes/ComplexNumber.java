package classes;

public class ComplexNumber {
    private double re, im;

    public ComplexNumber(double re, double im) {
        this.im = im;
        this.re = re;
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(re + c.getRe(), im + c.getIm());
    }

    public void add2(ComplexNumber c) {
        re = re + c.getRe();
        im = im + c.getIm();
    }

    public ComplexNumber sub(ComplexNumber c) {
        return new ComplexNumber(re - c.getRe(), im - c.getIm());
    }

    public void sub2(ComplexNumber c) {
        re = re - c.getRe();
        im = im - c.getIm();
    }

    public ComplexNumber multNumber(double f) {
        return new ComplexNumber(re * f, im * f);
    }

    public void multNumber2(double f) {
        re = re * f;
        im = im * f;
    }

    public ComplexNumber mult(ComplexNumber c) {
        return new ComplexNumber(re * c.getRe() - im * c.getIm(), im * c.getRe() + re * c.getIm());
    }

    public void mult2(ComplexNumber c) {
        re = re * c.getRe() - im * c.getIm();
        im = im * c.getRe() + re * c.getIm();
    }

    public ComplexNumber div(ComplexNumber c) {
        return new ComplexNumber(re * c.getRe() + im * c.getIm() / (double) (c.getRe() * c.getRe() + c.getIm() * c.getIm()),
                im * c.getRe() - re * c.getIm() / (double) (c.getRe() * c.getRe() + c.getIm() * c.getIm()));
    }

    public void div2(ComplexNumber c) {
        re = re * c.getRe() + im * c.getIm() / (double) (c.getRe() * c.getRe() + c.getIm() * c.getIm());
        im = im * c.getRe() - re * c.getIm() / (double) (c.getRe() * c.getRe() + c.getIm() * c.getIm());
    }

    public double length() {
        return Math.sqrt(re * re + im * im);
    }

    public String toString() {
        String s, s1;
        double a, b;
        if (re < 0) {
            a = -re;
            s = "- " + a + " ";
        } else {
            s = re + " ";
        }
        if (im < 0) {
            b = -im;
            s1 = "- " + b + " ";
        } else {
            s1 = "+ " + im + " ";
        }
        return s + s1 + "* i";
    }

    public double arg() {
        return Math.atan(im / re);
    }

    public ComplexNumber pow(double n) {
        double p = Math.pow(length(), n) * Math.cos(n * arg());
        double s = Math.pow(length(), n) * Math.sin(n * arg());
        return new ComplexNumber(p, s);
    }

    public boolean equals(Object obj) {
        ComplexNumber cn = (ComplexNumber) obj;
        return re == cn.getRe() && im == cn.getIm();
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

}
