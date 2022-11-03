package org.politex.models;

public class Equation {
    double a, b, c, s;

    public Equation() {
    }

    public Equation(double a, double b, double c, double s) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = s;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }
}
