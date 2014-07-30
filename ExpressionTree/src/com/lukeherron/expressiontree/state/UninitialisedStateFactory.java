package com.lukeherron.expressiontree.state;

import java.util.HashMap;

class UninitialisedStateFactory {

    // A HashMap that maps user format string requests to the corresponding UninitialisedState implementations.
    private HashMap<String, State> uninitialisedStateMap = new HashMap<>();

    UninitialisedStateFactory() {
        uninitialisedStateMap.put("in-order", new InOrderUninitialisedState());
        uninitialisedStateMap.put("pre-order", new PreOrderUninitialisedState());
        uninitialisedStateMap.put("post-order", new PostOrderUninitialisedState());
        uninitialisedStateMap.put("level-order", new LevelOrderUninitialisedState());
    }

    /**
     * Dynamically allocate a new State object based on the designated format
     * @param formatRequest String containing details of the State to transition to
     * @return State object relating to the format request
     */
    public State makeUninitialisedState(String formatRequest) {
        // Try to find the pre-allocated UninitialisedState implementation
        State state = uninitialisedStateMap.get(formatRequest);

        if (state != null) {
            return state;
        }
        else {
            throw new IllegalArgumentException(formatRequest + " is not a supported format");
        }
    }
}
