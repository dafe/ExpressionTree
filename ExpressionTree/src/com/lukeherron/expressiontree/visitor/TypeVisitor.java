package com.lukeherron.expressiontree.visitor;

import com.lukeherron.expressiontree.node.*;

public class TypeVisitor implements Visitor {

    String nodeType;

    @Override
    public void visit(CompositeAddNode node) {
        this.nodeType = "algebraic";
    }

    @Override
    public void visit(CompositeAndNode node) {
        this.nodeType = "boolean";
    }

    @Override
    public void visit(CompositeDivideNode node) {
        this.nodeType = "algebraic";
    }

    @Override
    public void visit(CompositeMultiplyNode node) {
        this.nodeType = "algebraic";
    }

    @Override
    public void visit(CompositeNegateNode node) {
        this.nodeType = "algebraic";
    }

    @Override
    public void visit(CompositeNotNode node) {
        this.nodeType = "boolean";
    }

    @Override
    public void visit(CompositeOrNode node) {
        this.nodeType = "boolean";
    }

    @Override
    public void visit(CompositeSubtractNode node) {
        this.nodeType = "algebraic";
    }

    @Override
    public void visit(AlgebraicLeafNode node) {
        this.nodeType = "boolean";
    }

    @Override
    public void visit(BooleanLeafNode node) {
        this.nodeType = "boolean";
    }

    public String getType() {
        return this.nodeType;
    }
}
