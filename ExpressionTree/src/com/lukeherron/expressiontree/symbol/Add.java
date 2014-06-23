package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeAddNode;

/**
 * Defines a node in the parse tree for the binary add operator non-terminal expression
 */
public class Add extends Operator {

    public Add() {
        super(null, null, addSubPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeAddNode(left.build(), right.build());
    }
}
