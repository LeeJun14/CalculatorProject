package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.print("첫 번째 값을 입력해주세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 값을 입력해주세요: ");
            int b = sc.nextInt();
            System.out.print("연산기호를 선택해주세요: ");
            char Operator = sc.next().charAt(0);


            Integer result = calc.calculate(a, b, Operator);

            if(result != null) {
                System.out.println(result);
                calc.printItem();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if(exit.equals("exit")) {
                break;
            } else {
                System.out.println("제일 오래된 값을 제거하시겠습니까? (yes 입력 시 제거)");
                String del =  sc.next();
                if(del.equals("yes")) {
                    calc.deleteItem();
                }
            }
        }
        sc.close();
    }
}

