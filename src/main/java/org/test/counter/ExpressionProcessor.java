package org.test.counter;

import org.test.storage.VariablesStorage;
import org.test.utils.CommonUtils;
import org.test.utils.PolishNotationConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionProcessor {

    private static final int accuracy = 10;

    public static String count(String expression) {
        if (expression.isEmpty()) {
            System.out.println("Please input correct expression first.");
            return "null";
        }
        PolishNotationConverter converter = new PolishNotationConverter();
        List<String> polishNotationExpression = converter.toReversePolishNotation(expression);

        List<String> readyToCountExpression = polishNotationExpression.stream()
                .map(part -> part.matches("^[a-zA-Z][a-zA-Z0-9]*$") ? String.valueOf(VariablesStorage.getOrGenerateVariable(part)) : part)
                .collect(Collectors.toList());

        return calcRPN(readyToCountExpression);
    }


    private static String calcRPN(List<String> revPolNotatArray) {
        List<BigDecimal> stack = new ArrayList<>();

        for (String it : revPolNotatArray) {
            if (CommonUtils.isNumeric(it)) {
                stack.add(new BigDecimal(it));
            } else {
                switch (it) {
                    case "+":
                        stack.add(stack.remove(stack.size() - 2).add(stack.remove(stack.size() - 1)));
                        break;
                    case "-":
                        stack.add(stack.remove(stack.size() - 2).subtract(stack.remove(stack.size() - 1)));
                        break;
                    case "*":
                        stack.add(stack.remove(stack.size() - 2).multiply(stack.remove(stack.size() - 1)));
                        break;
                    case "/":
                        stack.add(stack.remove(stack.size() - 2).divide(stack.remove(stack.size() - 1), accuracy, RoundingMode.HALF_EVEN));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + it);
                }
            }
        }
        BigDecimal result = stack.get(0);
        return String.valueOf(result);
    }


}
