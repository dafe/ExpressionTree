package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

public class BooleanExprCommand extends UserCommand {

    private String expr;

    public BooleanExprCommand(TreeOps context, String newExpr) {
        super.treeOps = context;
        expr = newExpr;
    }

    @Override
    public void execute() throws Exception {
        treeOps.makeTree(expr);
    }
}
