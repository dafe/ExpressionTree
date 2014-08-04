package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

public class EvalCommand extends UserCommand {

    private String format;

    public EvalCommand(TreeOps context, String evalFormat) {
        super.treeOps = context;
        this.format = evalFormat;
    }

    public void execute() throws Exception {
        treeOps.evaluate(this.format);
    }
}
