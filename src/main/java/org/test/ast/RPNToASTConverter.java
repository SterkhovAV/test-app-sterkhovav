package org.test.ast;

import org.test.ast.entities.ASTNode;
import org.test.ast.entities.OperandNode;
import org.test.ast.entities.OperatorNode;
import org.test.utils.CommonUtils;

import java.util.List;
import java.util.Stack;

public class RPNToASTConverter {

    public static ASTNode buildAST(List<String> tokens) {
        Stack<ASTNode> stack = new Stack<>();

        for (String token : tokens) {
            if (CommonUtils.isOperator(token)) {
                ASTNode right = stack.pop();
                ASTNode left = stack.pop();
                stack.push(new OperatorNode(token, left, right));
            } else {
                stack.push(new OperandNode(token));
            }
        }
        return stack.pop();
    }
}