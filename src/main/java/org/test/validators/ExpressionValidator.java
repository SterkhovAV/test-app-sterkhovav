package org.test.validators;

import org.test.utils.CommonUtils;

public class ExpressionValidator {

    public static boolean isExpressionValid(String expression) {

        //Check brackets balance in expression
        if (!CommonUtils.isBracketsBalanced(expression)) {
            System.out.println("Incorrect input: brackets is not balanced!");
            return false;
        }


        if (expression.contains("(") || expression.contains(")")) {
            if (CommonUtils.isSymbolsBeforeOrAfterBracketsCorrect(expression)) {
                System.out.println("Incorrect input: sings before or after brackets is incorrect!");
                return false;
            }
        }

        expression = expression.replaceAll("[()]", "");

        //Check sign duplicates
        if (CommonUtils.containsSignDuplicates(expression)) {
            System.out.println("Incorrect input: expression contains duplicate signs!");
            return false;
        }

        if (CommonUtils.isExpressionStartsOrEndsBySign(expression)) {
            System.out.println("Incorrect input: expression starts or ends by signs!");
            return false;
        }

        //Get parts and validate them
        String signs = "[+\\-*/]";
        String[] parts = expression.split(signs);


        for (String part : parts) {
            if (!part.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
                if (part.matches("^\\d+$")) {
                    if (!CommonUtils.isNumberSizeCorrect(part)) {
                        System.out.println("Incorrect input: " + part + " is an invalid constant term (out of 16-bit positive range)!");
                        return false;
                    }
                } else {
                    System.out.println("Incorrect input: " + part + " contains invalid symbols!");
                    return false;
                }
            }
        }
        return true;
    }
}