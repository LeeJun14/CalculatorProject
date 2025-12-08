package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int calculate(int a, int b, char Operator) {
        switch (Operator) {
            case '+':
                list.add(a + b);
                break;

            case  '-':
                list.add(a - b);
                break;

            case   '*':
                list.add(a * b);
                break;

            case  '/':
                list.add(a / b);
                break;
        }
        return list.get(list.size()-1);
    }
}
