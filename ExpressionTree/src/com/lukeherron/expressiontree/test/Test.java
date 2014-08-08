package com.lukeherron.expressiontree.test;

import com.lukeherron.expressiontree.BooleanExpressionTree;
import com.lukeherron.expressiontree.ShiggedyTree;
import com.lukeherron.expressiontree.command.UserCommandFactory;
import com.lukeherron.expressiontree.state.TreeOps;

public class Test {

    public static void main(String[] args) {

        ShiggedyTree shiggedy = new ShiggedyTree();
        shiggedy.booleanTest("test", "test").and("test", "test");

        //TreeOps boolTreeOps = new TreeOps(new BooleanExpressionTree(null));
        //UserCommandFactory commandFactory = new UserCommandFactory(boolTreeOps);
        //try {
        //    commandFactory.makeUserCommand("algebraic-macro -5*(3+4)").execute();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        //TreeOps boolTreeOps = new TreeOps(new BooleanExpressionTree(null));
        //TreeOps algebraicTreeOps = new TreeOps(new AlgebraicExpressionTree(null));

        //boolTreeOps.format();
        //boolTreeOps.makeTree("1&0|1&!1");
        //boolTreeOps.evaluate();
        //System.out.println(true && false || true && !true);

        //algebraicTreeOps.format();
        //algebraicTreeOps.makeTree("1+2+3+4");
        //algebraicTreeOps.evaluate();

        //Interpreter interpreter = new Interpreter(new ExpressionTreeFactory());
        //ExpressionTree tree = interpreter.interpret("1&0|1&!1", "boolean");
        //ExpressionTree tree = interpreter.interpret("-5*(3+4)", "algebraic");

        //VisitorFactory visitorFactory = new VisitorFactory();
        //Visitor printVisitor = visitorFactory.makeVisitor("print");
        //Visitor evalVisitor = visitorFactory.makeVisitor("bool-eval");

        //for (Iterator<ExpressionTree> it = tree.makeIterator(""); it.hasNext();) {
        //    it.next().accept(printVisitor);
        //}

        //for (Iterator<ExpressionTree> it = tree.makeIterator("post-order"); it.hasNext();) {
        //    it.next().accept(evalVisitor);
        //}
        //System.out.println();
        //System.out.println(((BooleanEvalVisitor) evalVisitor).result());
        //System.out.println(true && false || true && !true);
    }
}
