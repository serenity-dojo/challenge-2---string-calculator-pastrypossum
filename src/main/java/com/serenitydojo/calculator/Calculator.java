package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;
import java.util.StringTokenizer;

public class Calculator {

    private int currentTotal = 0;
    private String currentOperator = "";

    public int evaluate(String expression) {

        if(expression.isEmpty())
            return 0;

        StringTokenizer tokenizer = new StringTokenizer(expression, " ");
        String firstToken = tokenizer.nextToken();
        System.out.println("First token: " + firstToken);

        if (StringUtils.isNumeric(firstToken)) {
            currentTotal = Integer.parseInt(firstToken);
        }

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();
            System.out.println("Next token: " + token);

            if (!StringUtils.isNumeric(token)) {
                // operator
                currentOperator = token;
            }
            else {
                // number
                int nextNumber = Integer.parseInt(token);
                currentTotal = calculate(currentTotal, currentOperator, nextNumber);
                System.out.println("Current total: " + currentTotal);
            }
        }
        return currentTotal;
    }

    private int calculate (int total, String operator, int nextNumber) {

        switch (operator) {
            case "+":
                return total + nextNumber;
            case "-":
                return total - nextNumber;
            case "*":
                return total * nextNumber;
            default: {
                throw new IllegalMathsOperatorException("Unknown operator: " + operator);
            }
        }
    }
}
