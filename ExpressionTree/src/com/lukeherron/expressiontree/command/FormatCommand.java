package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

public class FormatCommand extends UserCommand {

    private String format;

    FormatCommand(TreeOps context, String newFormat) {
        super.treeOps = context;
        format = newFormat;
    }

    @Override
    public void execute() throws Exception {
        treeOps.format(format);
    }
}
