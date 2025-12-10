package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator<T extends Number> {
    // 직접 접근이 불가능한 객체 생성
    private List<T> list = new ArrayList<>();

    // list 값을 반환하는 메서드
    public List<T> getItem() {
        return list;
    }

    // list에 값을 넣는 에서드
    public void setItem(T item) {
        list.add(item);
    }

    // list의 0 번째 인덱스를 제거하는 메서드
    public void deleteItem() {
        if(list.isEmpty()) {
            System.out.println("삭제할 값이 없습니다.");
        }
        list.remove(0);
        System.out.println("값이 삭제되었습니다.");
    }

    // 현재까지 들어온 list 값을 반환하는 메서드
    public void printItems() {
        for (T item : list) {
            if(list.isEmpty()) {
                System.out.println("현재 연산된 값이 존재하지 않습니다.");
            }
            System.out.println("현재 연산 목록: " + item);
        }
    }
    // 연산자 정보 관리
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

    // 계산 값 저장
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
