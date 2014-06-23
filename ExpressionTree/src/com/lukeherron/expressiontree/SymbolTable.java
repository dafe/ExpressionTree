package com.lukeherron.expressiontree;

import java.util.HashMap;

/**
 * SymbolTable class stores variables and their values for use by the Intepreter class
 */
public class SymbolTable {

    private HashMap<String, Integer> map = new HashMap<>();

    public SymbolTable() {}

    public int get(String variable) {
        if (map.get(variable) == null) {
            map.put(variable, 0);
        }

        return map.get(variable);
    }

    public void set(String variable, int value) {
        map.put(variable, value);
    }

    /**
     * Clear all variables and their values
     */
    public void reset() {
        map.clear();
    }
}
