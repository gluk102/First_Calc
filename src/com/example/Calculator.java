package com.example;

import java.util.Scanner;
public class Calculator {

    private String[] tokens;
    private int pos;

    public static void main(String[] args) {
        System.out.println("Введите выражение для вычисления");
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        Calculator calculator = new Calculator(expr);
        System.out.println(expr + "= " + calculator.calculator());
    }

    public Calculator(String expr) {
        this.tokens = expr.split(" ");
        this.pos = 0;
    }

    public double calculator() {
        double first = multiply();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {

                first -= second;
            }

        }
        return first;
    }
    public double multiply() {
        double first = Double.parseDouble(tokens[pos++]);

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            double second = Double.parseDouble(tokens[pos++]);
            if (operator.equals("*")) {
                first *= second;
            } else {

                first /= second;
            }

        }
        return first;
    }
}
