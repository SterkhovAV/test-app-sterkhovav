package org.test.ast.entities;

public class OperatorNode extends ASTNode {
    String operator;
    ASTNode left;
    ASTNode right;

    public OperatorNode(String operator, ASTNode left, ASTNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "`-- " : "|-- ") + operator);
        if (right != null) {
            right.print(prefix + (isTail ? "    " : "|   "), false);
        }
        if (left != null) {
            left.print(prefix + (isTail ? "    " : "|   "), true);
        }
    }
}