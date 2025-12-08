package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        while (true) {
            System.out.print("첫 번째 값을 입력해주세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 값을 입력해주세요: ");
            int b = sc.nextInt();
            System.out.print("연산기호를 선택해주세요: ");
            char Operator = sc.next().charAt(0);

            boolean flag = true;

            switch (Operator) {
                case '+':
                    result = a + b;
                    break;

                case  '-':
                    result = a - b;
                    break;

                case  '*':
                    result = a * b;
                    break;

                case '/':
                    if(b == 0) {
                        flag = false;
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    } else {
                        result = a / b;
                        break;
                    }


                default:
                    System.out.println("유효하지 않은 연산기호입니다.");
                    flag = false;
                    break;
            }
            if(!flag) {
                continue;
            } else {
                System.out.println(result);
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if(exit.equals("exit")) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
