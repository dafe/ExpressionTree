package com.lukeherron.expressiontree.state;

public class PreOrderInitialisedState extends PreOrderUninitialisedState {

    public PreOrderInitialisedState() {}

    void print(TreeOps context, String format) {
        State.printTree(context.tree(), format);
    }

    void evaluate(TreeOps context, String format) {
        throw new IllegalArgumentException("PreOrderInitialisedState.evaluate() not yet implemented");
    }
}
