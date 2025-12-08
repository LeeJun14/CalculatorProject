package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> list = new ArrayList<Integer>();

    public List<Integer> getItem() {
        return list;
    }

    public void setItem(Integer item) {
        list.add(item);
    }

    public void deleteItem() {
        list.remove(0);
    }

    public void printItem() {
        for (Integer item : list) {
            System.out.println("현재 연산 목록: " + item);
        }
    }

    public Integer calculate(int a, int b, char Operator) {
        Integer result = null;

        switch (Operator) {
            case '+':
                result = a + b;
                setItem(result);
                break;

            case  '-':
                result = a - b;
                setItem(result);
                break;

            case   '*':
                result = a * b;
                setItem(result);
                break;

            case  '/':
                if(b == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    return null;
                } else {
                    result = a / b;
                    setItem(result);
                    break;
                }

            default:
                System.out.println("유효하지 않은 연산기호입니다.");
                return null;
        }
        return result;
    }
}
