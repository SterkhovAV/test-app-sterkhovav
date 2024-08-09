package org.test;

import org.test.ast.ASTBuilder;
import org.test.counter.ExpressionProcessor;
import org.test.counter.UpdateProcessor;
import org.test.validators.ExpressionValidator;
import org.test.storage.VariablesStorage;
import org.test.validators.UpdateValidator;

import java.util.Scanner;

public class Main {

    private static String expression = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("calc")) {
                System.out.println("Result: " + ExpressionProcessor.count(expression));
                VariablesStorage.printVariablesAndValues();
                continue;
            }

            if (input.equalsIgnoreCase("print")) {
                ASTBuilder.createAndPrintAST(expression);
                continue;
            }

            input = input.replaceAll("\\s+", "");

            if (input.contains("=")) {
                if (UpdateValidator.isUpdateValid(input)) {
                    UpdateProcessor.update(input);
                } else System.out.println("Incorrect input: update must be like \"x1=10\"!");

            } else {
                boolean isExpressionValid = ExpressionValidator.isExpressionValid(input);
                if (isExpressionValid) {
                    expression = input;
                    VariablesStorage.cleanUpVariablesStorage();
                    System.out.println("Result: " + ExpressionProcessor.count(expression));
                    VariablesStorage.printVariablesAndValues();
                }
            }
        }
        scanner.close();
        System.out.println("Program exited.");
    }
}