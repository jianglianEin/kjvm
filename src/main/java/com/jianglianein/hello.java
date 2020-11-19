package com.jianglianein;

public class hello {
    public static void main(String[] args) {
        int c = count(4, 1);

        System.out.println(fib(c));
    }

    static int count(int a, int b) {
        return countThreeNum(a, b, 1);
    }

    static int countThreeNum(int a, int b, int c) {
        return a + b + c;
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
