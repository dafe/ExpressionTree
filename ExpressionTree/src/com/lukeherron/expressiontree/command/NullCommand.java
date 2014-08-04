package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

public class NullCommand extends UserCommand {

    public NullCommand(TreeOps context) {
        super.treeOps = context;
    }

    @Override
    public void execute() throws Exception {
        // No-op
    }
}
