package org.test.ast;

import org.test.ast.entities.ASTNode;
import org.test.utils.PolishNotationConverter;

import java.util.List;

public class ASTBuilder {

        public static void createAndPrintAST(String expression) {
        if (expression.isEmpty()) {
            System.out.println("Please input correct expression first.");
            return;
        }

        PolishNotationConverter converter = new PolishNotationConverter();
        List<String> polishNotationExpression = converter.toReversePolishNotation(expression);

        ASTNode result = RPNToASTConverter.buildAST(polishNotationExpression);
        result.print("", true);
    }
}
