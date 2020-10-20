package pl.coderslab.calculator;


public class MaxValue {
    public static int largest(int[] list) {
        int index, max = Integer.MIN_VALUE;

        if (list.length == 0) {
            throw new RuntimeException("Lista jest pusta");
        }

        for (index = 0; index < list.length - 1; index++) {
            if (list[index] > max) {
                max = list[index+1];
            }
        }
        return max;
    }

}