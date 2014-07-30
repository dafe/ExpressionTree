package com.lukeherron.expressiontree.state;

public class PostOrderUninitialisedState extends UninitialisedState {

    public PostOrderUninitialisedState() {}

    void makeTree(TreeOps context, String expression) {
        throw new IllegalStateException("PostOrderUninitialisedState.makeTree() not yet implemented");
    }
}
