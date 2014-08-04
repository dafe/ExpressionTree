package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

import java.util.ArrayList;

public class MacroCommand extends UserCommand {

    private ArrayList<UserCommand> macroCommands = new ArrayList<>();

    MacroCommand(TreeOps context, ArrayList<UserCommand> macroCommands) {
        super.treeOps = context;
        this.macroCommands = macroCommands;
    }

    @Override
    public void execute() throws Exception {
        for (UserCommand command: macroCommands) {
            command.execute();
        }
    }
}
