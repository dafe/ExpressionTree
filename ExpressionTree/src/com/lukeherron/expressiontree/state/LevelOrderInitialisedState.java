package com.lukeherron.expressiontree.state;

public class LevelOrderInitialisedState extends LevelOrderUninitialisedState {

    public LevelOrderInitialisedState() {}

    void print(TreeOps context, String format) {
        State.printTree(context.tree(), format);
    }

    void evaluate(TreeOps context, String format) {
        throw new IllegalArgumentException("LevelOrderInitialisedState.evaluate() not yet implemented");
    }
}
