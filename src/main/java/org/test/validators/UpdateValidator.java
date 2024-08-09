package org.test.validators;

import org.test.utils.CommonUtils;

public class UpdateValidator {

    public static boolean isUpdateValid(String update) {

        String[] parts = update.split("=");

        //Must be 2 parts if its correct update
        if (parts.length != 2) {
            return false;
        }

        if (CommonUtils.isVariable(parts[0]) && CommonUtils.isNumeric(parts[1]) && CommonUtils.isNumberSizeCorrect((parts[1]))) {
            return true;
        }

        return false;
    }
}
