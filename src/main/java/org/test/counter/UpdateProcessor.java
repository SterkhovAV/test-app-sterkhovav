package org.test.counter;

import org.test.storage.VariablesStorage;

import static org.test.storage.VariablesStorage.isVariableExists;

public class UpdateProcessor {

    public static void update(String update) {
        String[] parts = update.split("=");
        if (!isVariableExists(parts[0])) {
            System.out.println("Variable " + parts[0] + " is not exists!");
            return;
        }
        VariablesStorage.updateVariable(parts[0], parts[1]);
    }

}
