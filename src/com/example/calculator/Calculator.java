package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String reseltMessage = "";


        System.out.print("첫 번째 값을 입력해주세요: ");
        int a = sc.nextInt();
        System.out.print("두 번째 값을 입력해주세요: ");
        int b = sc.nextInt();
        System.out.print("연산기호를 선택해주세요: ");
        char Operator = sc.next().charAt(0);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Operator = " + Operator);


    }
}
