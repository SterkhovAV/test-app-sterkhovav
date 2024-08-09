package org.test.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;

public class VariablesStorage {

    private static final HashMap<String, Integer> variablesStorage = new HashMap<>();

    public static void cleanUpVariablesStorage() {
        variablesStorage.clear();
    }

    public static int getOrGenerateVariable(String variable) {
        Integer value = variablesStorage.get(variable);

        if (value == null) {
            value = getRandomValue();
            variablesStorage.put(variable, value);
        }
        return value;
    }

    private static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(65536);
    }

    public static void printVariablesAndValues() {
        StringJoiner joiner = new StringJoiner("; ", "", "");

        for (Map.Entry<String, Integer> entry : variablesStorage.entrySet()) {
            joiner.add(entry.getKey() + "=" + entry.getValue());
        }

        String result = joiner.toString();
        if (!result.isEmpty()) {
            System.out.println("Variables " + result);
        }
    }

    public static boolean isVariableExists(String variable) {
        Integer value = variablesStorage.get(variable);
        return (value != null);
    }

    public static void updateVariable(String variable, String value) {
        variablesStorage.put(variable, Integer.valueOf(value));
    }
}
