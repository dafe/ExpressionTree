package com.lukeherron.expressiontree.test;

import com.lukeherron.expressiontree.ExpressionTree;
import com.lukeherron.expressiontree.ExpressionTreeFactory;
import com.lukeherron.expressiontree.Interpreter;

public class Test {

    public static void main(String[] args) {

        ExpressionTreeFactory f = new ExpressionTreeFactory();
        //ExpressionTree tree = f.makeExpressionTree(new CompositeAddNode(new AlgebraicLeafNode("28"), new AlgebraicLeafNode("34")));
        //ExpressionTree tree = f.makeExpressionTree(new CompositeAndNode(new BooleanLeafNode(true), new BooleanLeafNode(false)));
        Interpreter interpreter = new Interpreter(f);
        ExpressionTree tree = interpreter.interpret("1 & 2 | 3 ! 4");
        System.out.println(tree.isNull());
    }
}
