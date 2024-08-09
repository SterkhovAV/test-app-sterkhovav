package org.test.utils;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    public static boolean isNumericOrVariable(String str) {
        // Variable
        if (str.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
            return true;
        }

        // Numeric
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isVariable(String str) {
        // Variable
        if (str.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
            return true;
        } else return false;
    }

    public static boolean isLatinLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }


    public static boolean isNumberSizeCorrect(String part) {
        try {
            int number = Integer.parseUnsignedInt(part);
            return number <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBracketsBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean containsSignDuplicates(String expression) {
        // Regular expression to find two or more consecutive math signs
        String pattern = "(\\+{2,}|-{2,}|\\*{2,}|/{2,})";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(expression);

        return matcher.find();
    }

    public static boolean isExpressionStartsOrEndsBySign(String expression) {
        String pattern = "^[+\\-*/].*|.*[+\\-*/]$";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(expression);

        return matcher.matches();
    }


    public static boolean isSymbolsBeforeOrAfterBracketsCorrect(String expression) {
        String pattern = "^(.*?)([\\+\\-\\*\\/]|^)\\((.*?)\\)([\\+\\-\\*\\/]|$)(.*)$";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(expression);

        return !matcher.matches();
    }
}
