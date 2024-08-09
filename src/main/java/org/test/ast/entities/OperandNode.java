package org.test.ast.entities;

public class OperandNode extends ASTNode {
    String value;

    public OperandNode(String value) {
        this.value = value;
    }

    @Override
    public void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "`-- " : "|-- ") + value);
    }
}