package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator<T extends Number> {
    private List<T> list = new ArrayList<>();

    public List<T> getItem() {
        return list;
    }

    public void setItem(T item) {
        list.add(item);
    }

    public void deleteItem() {
        list.remove(0);
    }

    public void printItem() {
        for (T item : list) {
            System.out.println("현재 연산 목록: " + item);
        }
    }

    public enum OperatorType {
        PLUS() {
            @Override
            public <T extends Number> Number apply(T a, T b) {
                if(a instanceof Integer && b instanceof Integer) {
                    return a.intValue() + b.intValue();
                }
                return a.doubleValue() + b.doubleValue();
            }
        },
        MINUS() {
            @Override
            public <T extends Number> Number apply(T a, T b) {
                if(a instanceof Integer && b instanceof Integer) {
                    return a.intValue() - b.intValue();
                }
                return a.doubleValue() - b.doubleValue();
            }
        },
        MULTIPLY() {
            @Override
            public <T extends Number> Number apply(T a, T b) {
                if(a instanceof Integer && b instanceof Integer) {
                    return a.intValue() * b.intValue();
                }
                return a.doubleValue() * b.doubleValue();
            }
        },
        DIVIDE() {
            @Override
            public <T extends Number> Number apply(T a, T b) {
                if(a instanceof Integer && b instanceof Integer) {
                    return a.intValue() / b.intValue();
                }
                return a.doubleValue() / b.doubleValue();
            }
        };
        public abstract <T extends Number> Number apply(T a, T b);
    }

    public Number getInput(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if(sc.hasNextInt()) {
                return sc.nextInt();
            } else if(sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("유효하지 않은 입력입니다.");
                sc.next();
            }
        }
    }

    public Number calculate(Number a, Number b, char Operator) {
        T result = null;

        switch (Operator) {
            case '+':
                result = (T) OperatorType.PLUS.apply(a, b);
                setItem(result);
                break;

            case  '-':
                result = (T) OperatorType.MINUS.apply(a, b);
                setItem(result);
                break;

            case   '*':
                result = (T) OperatorType.MULTIPLY.apply(a, b);
                setItem(result);
                break;

            case  '/':
                if(b.doubleValue() == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    return null;
                } else {
                    result = (T) OperatorType.DIVIDE.apply(a, b);
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
