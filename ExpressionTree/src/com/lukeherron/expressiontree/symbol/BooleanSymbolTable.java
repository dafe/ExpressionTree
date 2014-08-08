package com.lukeherron.expressiontree.symbol;

import java.util.HashMap;

/**
 * BooleanSymbolTable class stores variables and their values for use by the Intepreter class
 */
public class BooleanSymbolTable {

    private HashMap<String, Boolean> map = new HashMap<>();

    public BooleanSymbolTable() {}

    public boolean get(String variable) {
        return map.get(variable);
    }

    public void set(String variable, boolean value) {
        map.put(variable, value);
    }

    public void reset() {
        map.clear();
    }
}
