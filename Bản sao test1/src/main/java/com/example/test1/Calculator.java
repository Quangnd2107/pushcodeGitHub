package com.example.test1;

public class Calculator {
    public  int add(int a, int b){
        return a+b;
    }
    public double divide(int a, int b){
        if ( b ==0){
            throw new ArithmeticException("Khong the chia cho 0");
        }
        return (double) a/b;
    }
}
