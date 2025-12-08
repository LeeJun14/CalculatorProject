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

    public enum OperatorType {
        PLUS() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        MINUS() {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        },
        DIVIDE() {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        };

        public abstract int apply(int a, int b);
    }

    public Integer calculate(int a, int b, char Operator) {
        Integer result = null;

        switch (Operator) {
            case '+':
                result = OperatorType.PLUS.apply(a, b);
                setItem(result);
                break;

            case  '-':
                result = OperatorType.MINUS.apply(a, b);
                setItem(result);
                break;

            case   '*':
                result = OperatorType.MULTIPLY.apply(a, b);
                setItem(result);
                break;

            case  '/':
                if(b == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    return null;
                } else {
                    result = OperatorType.DIVIDE.apply(a, b);
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
