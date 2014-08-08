package com.lukeherron.expressiontree.test;

import com.lukeherron.expressiontree.ShiggedyTree;

public class Test {

    public static void main(String[] args) {

        ShiggedyTree shiggedy = new ShiggedyTree();

        try {
            boolean result = shiggedy.booleanTest("test", "test").and("test", "test").eval();
            //int total = shiggedy.calculate("-5*(3+4)").divide(5).eval();
            //double total = shiggedy.calculate(-5).multiply().openParens(3).add(4).closeParens().divide(5).eval();
            double total = shiggedy.calculate(4).add(7).add(9).multiply(4).divide(2).subtract(2).eval();
            System.out.println(result);
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
