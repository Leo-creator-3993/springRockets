package com.future.spring.rocket.test;

public class JunitModel {

    public static int max(int ... arr) {
        int max = Integer.MIN_VALUE;
        for(int item : arr) {
            if(item > max) {
                max = item;
            }
        }

        return max;
    }

    public static int min(int ... arr) {
        int min = Integer.MAX_VALUE;
        for(int item : arr) {
            if(item < min) {
                min = item;
            }
        }
        return min;
    }
}
