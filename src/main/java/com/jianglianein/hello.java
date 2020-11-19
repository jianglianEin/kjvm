package com.jianglianein;

public class hello {
    public static void main(String[] args) {
        int c = count(4, 1);

        System.out.println(fib(c));
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.out.println(countArray(arr));
    }

    static int count(int a, int b) {
        return countThreeNum(a, b, 1);
    }

    static int countThreeNum(int a, int b, int c) {
        return a + b + c;
    }

    static int countArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    static int fib(int count) {
        if (count == 1) {
            return 1;
        }else if (count == 0){
            return 0;
        }
        return fib(count - 1) + fib(count - 2);
    }
}
