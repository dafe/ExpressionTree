package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

/**
 * Sets a variable into the SymbolTale stored inside of TreeOps. This plays the role of the "ConcreteCommand" in the
 * Command Pattern
 */
public class SetCommand extends UserCommand {

    private String keyValuePair;

    SetCommand(TreeOps context, String keyValuePair) {
        super.treeOps = context;
        this.keyValuePair = keyValuePair;
    }

    @Override
    public void execute() throws Exception {
        treeOps.set(keyValuePair);
    }
}
