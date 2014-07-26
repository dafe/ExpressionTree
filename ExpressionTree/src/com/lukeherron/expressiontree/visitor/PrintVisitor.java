package com.lukeherron.expressiontree.visitor;

import com.lukeherron.expressiontree.node.*;

public class PrintVisitor implements Visitor {

    public PrintVisitor() {}

    @Override
    public void visit(CompositeAddNode node) {
        System.out.print("+ ");
    }

    @Override
    public void visit(CompositeAndNode node) {
        System.out.print("& ");
    }

    @Override
    public void visit(CompositeDivideNode node) {
        System.out.print("/ ");
    }

    @Override
    public void visit(CompositeMultiplyNode node) {
        System.out.print("* ");
    }

    @Override
    public void visit(CompositeNegateNode node) {
        System.out.print("-");
    }

    @Override
    public void visit(CompositeNotNode node) {
        System.out.print("!");
    }

    @Override
    public void visit(CompositeOrNode node) {
        System.out.print("| ");
    }

    @Override
    public void visit(CompositeSubtractNode node) {
        System.out.print("- ");
    }

    @Override
    public void visit(AlgebraicLeafNode node) {
        System.out.print(node.item() + " ");
    }

    @Override
    public void visit(BooleanLeafNode node) {
        System.out.print(node.item() + " ");
    }
}
