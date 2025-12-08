package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public Integer calculate(int a, int b, char Operator) {
        Integer result = null;

        switch (Operator) {
            case '+':
                result = a + b;
                list.add(result);
                break;

            case  '-':
                result = a - b;
                list.add(result);
                break;

            case   '*':
                result = a * b;
                list.add(result);
                break;

            case  '/':
                if(b == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    return null;
                } else {
                    result = a / b;
                    list.add(result);
                    break;
                }

            default:
                System.out.println("유효하지 않은 연산기호입니다.");
                return null;
        }
        return result;
    }
}
