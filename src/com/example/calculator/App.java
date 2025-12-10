package com.example.calculator;

import java.util.Scanner;

public class App {

    public static Number getInput(Scanner sc, String message) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator<Number> calc = new Calculator();

        while (true) {
            Number a = getInput(sc, "첫 번째 값을 입력해주세요: ");
            Number b = getInput(sc, "두 번째 값을 입력해주세요: ");
            System.out.print("연산기호를 선택해주세요: ");
            char Operator = sc.next().charAt(0);


            Number result = calc.calculate(a, b, Operator);

            if(result != null) {
                System.out.println(result);
                calc.printItems();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if(exit.equals("exit")) {
                break;
            }

            System.out.println("제일 오래된 값을 제거하시겠습니까? (yes 입력 시 제거)");
            String del =  sc.next();
            if(del.equals("yes")) {
                calc.deleteItem();
            }
            System.out.println("입력받은 값보다 큰 저장된 값을 출력하시겠습니까? (yes 입력 시 출력)");
            String printBigger = sc.next();
            if (printBigger.equals("yes")) {
                Number c = getInput(sc, "값을 입력해주세요: ");
                calc.getItem().stream().filter(x -> x.doubleValue() > c.doubleValue()).forEach(x -> System.out.println("입력 값보다 큰 값 목록: " + x));
            }
            System.out.println("특정 인덱스의 값을 확인하시겠습니까? (yes 입력 시 배열 선택)");
            String printSmaller = sc.next();
            if (printSmaller.equals("yes")) {
                System.out.print("몇 번째 인덱스을 가져오시겠습니까: ");
                int choiceValue = sc.nextInt();

                try {
                    Number number = calc.getItem().get(choiceValue);
                    if(number != null) {
                        System.out.println(choiceValue + " 번째 인덱스의 값은: " + number);
                    }
                }  catch (IndexOutOfBoundsException e) {
                    System.out.println("선택하신 인덱스는 아직 값이 들어오지 않았습니다.");
                }

            }
        }
        sc.close();
    }
}

