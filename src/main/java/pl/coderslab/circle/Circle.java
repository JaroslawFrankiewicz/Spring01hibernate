package pl.coderslab.circle;

public class Circle {
    private static final float PI = 3.14f;

    public static double  circleArea(int r) {
        if (r < 0) {
            throw new RuntimeException("Promień nie może być mniejszy od 0");
        }
        double area =  Math.PI * r * r;

        return area;
    }
}
