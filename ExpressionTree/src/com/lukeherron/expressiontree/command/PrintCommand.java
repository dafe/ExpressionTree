package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

public class PrintCommand extends UserCommand {

    private String format;

    public PrintCommand(TreeOps context, String printFormat) {
        super.treeOps = context;
        format = printFormat;
    }

    @Override
    public void execute() throws Exception {
        treeOps.print(format);
    }
}
