package com.lukeherron.expressiontree.test;

import com.lukeherron.expressiontree.ExpressionTree;
import com.lukeherron.expressiontree.ExpressionTreeFactory;
import com.lukeherron.expressiontree.Interpreter;
import com.lukeherron.expressiontree.visitor.BooleanEvalVisitor;
import com.lukeherron.expressiontree.visitor.Visitor;
import com.lukeherron.expressiontree.visitor.VisitorFactory;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        Interpreter interpreter = new Interpreter(new ExpressionTreeFactory());
        ExpressionTree tree = interpreter.interpret("1&0|1&!1", "boolean");
        //ExpressionTree tree = interpreter.interpret("-5*(3+4)", "algebraic");

        VisitorFactory visitorFactory = new VisitorFactory();
        Visitor printVisitor = visitorFactory.makeVisitor("print");
        Visitor evalVisitor = visitorFactory.makeVisitor("boolEval");

        for (Iterator<ExpressionTree> it = tree.makeIterator(""); it.hasNext();) {
            it.next().accept(printVisitor);
        }

        for (Iterator<ExpressionTree> it = tree.makeIterator("post-order"); it.hasNext();) {
            it.next().accept(evalVisitor);
        }
        System.out.println();
        System.out.println(((BooleanEvalVisitor) evalVisitor).result());
        System.out.println(true && false || true && !true);
    }
}
