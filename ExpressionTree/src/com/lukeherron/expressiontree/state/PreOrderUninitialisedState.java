package com.lukeherron.expressiontree.state;

public class PreOrderUninitialisedState extends UninitialisedState {

    public PreOrderUninitialisedState() {}

    void makeTree(TreeOps context, String format) {
        throw new IllegalStateException("PreOrderUninitializedState.makeTree() not yet implemented");
    }
}
