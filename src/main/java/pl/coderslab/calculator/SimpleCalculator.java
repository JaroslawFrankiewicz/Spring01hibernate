package pl.coderslab.calculator;

public class SimpleCalculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int addPositive(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Only positive");
        } else {
            return x + y;
        }
    }
}
