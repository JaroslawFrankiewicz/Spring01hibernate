package pl.coderslab.calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / (b * 1.0);
    }

    public boolean greater(int a, int b) {
        return a > b;
    }

    public int eval(String s) {
        String a = "1";
        String b = "2";
        String c = "3";
        s= a + b +c;

        return eval(s);
    }
}
