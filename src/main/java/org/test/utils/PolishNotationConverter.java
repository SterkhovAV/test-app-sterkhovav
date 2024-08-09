package org.test.utils;

import java.util.ArrayList;
import java.util.List;

public class PolishNotationConverter {

    private final List<String> result = new ArrayList<>();
    private final List<String> buffer = new ArrayList<>();

    public List<String> toReversePolishNotation(String expression) {
        List<String> array = makeArray(expression);
        // обозначение конца массива
        array.add("!!!");
        for (String it : array) {
            if (CommonUtils.isNumericOrVariable(it)) {
                result.add(it);
            } else {
                switch (it) {
                    case "+":
                    case "-":
                        if (buffer.isEmpty() || buffer.get(buffer.size() - 1).equals("(")) {
                            push(it);
                        } else if (buffer.get(buffer.size() - 1).equals("*") || buffer.get(buffer.size() - 1).equals("/")) {
                            popAll();
                            push(it);
                        } else {
                            popLastPushIt(it);
                        }
                        break;
                    case "*":
                    case "/":
                        if (!buffer.isEmpty() && (buffer.get(buffer.size() - 1).equals("*") || buffer.get(buffer.size() - 1).equals("/"))) {
                            popLastPushIt(it);
                        } else {
                            push(it);
                        }
                        break;
                    case "(":
                        push(it);
                        break;
                    case ")":
                        popAll();
                        break;
                    default:
                        popAll();
                        break;
                }
            }
        }
        return result;
    }

    private List<String> makeArray(String expression) {
        List<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch) || CommonUtils.isLatinLetter(ch)) {
                buffer.append(ch);
            } else {
                if (buffer.length() > 0) {
                    result.add(buffer.toString());
                    buffer.setLength(0);
                }
                result.add(Character.toString(ch));
            }
        }

        if (buffer.length() > 0) {
            result.add(buffer.toString());
        }

        return result;
    }

    private void push(String it) {
        buffer.add(it);
    }

    private void popLastPushIt(String it) {
        result.add(buffer.get(buffer.size() - 1));
        buffer.set(buffer.size() - 1, it);
    }

    private void popAll() {
        for (int i = buffer.size() - 1; i >= 0; i--) {
            if (buffer.get(i).equals("(")) {
                buffer.remove(i);
                break;
            }
            result.add(buffer.get(i));
            buffer.remove(i);
        }
    }
}

