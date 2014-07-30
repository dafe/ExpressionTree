package com.lukeherron.expressiontree.state;

/**
 * A state without an initialised context or format.
 */
class UninitialisedState extends State {

    // A state factory responsible for building uninitialised states.
    private static UninitialisedStateFactory uninitialisedStateFactory = new UninitialisedStateFactory();

    public void format(TreeOps context, String newFormat) {
        if (newFormat.equals("")) {
            newFormat = "in-order";
        }
        else if (!newFormat.equals("in-order")) {
            throw new IllegalArgumentException(newFormat + " evaluation is not supported yet");
        }

        // Transition to the designated UninitialisedState
        context.state(uninitialisedStateFactory.makeUninitialisedState(newFormat));
    }
}
