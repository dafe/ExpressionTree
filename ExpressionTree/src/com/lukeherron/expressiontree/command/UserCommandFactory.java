package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of the Factory Method pattern that dynamically allocates the appropriate UserCommand object requested
 * by the caller. This variant of the pattern doesn't use inheritance, so it plays the role of the ConcreteCreator in
 * the Factory Method pattern
 */
public class UserCommandFactory {

    private TreeOps treeOps;
    private HashMap<String, IUserCommandFactoryCommand> commandMap = new HashMap<>();

    public UserCommandFactory(final TreeOps treeOps) {
        this.treeOps = treeOps;

        // A format string maps to a command object that creates a FormatCommand implementation
        commandMap.put("format", param -> new FormatCommand(treeOps, param));
        // An expr string maps to a command object that creates an AlgebraicExprCommand implementation
        commandMap.put("algebraic-expr", param -> new AlgebraicExprCommand(treeOps, param));
        // An expr string maps to a command object that creates a BooleanExprCommand implementation
        commandMap.put("boolean-expr", param -> new BooleanExprCommand(treeOps, param));
        // A print string maps to a command object that creates a PrintCommand implementation
        commandMap.put("print", param -> new PrintCommand(treeOps, param));
        // An eval string maps to a command object that creates an EvalCommand implementation
        commandMap.put("eval", param -> new EvalCommand(treeOps, param));
        // A set string maps to a command object that creates a SetCommand implementation
        commandMap.put("set", param -> new SetCommand(treeOps, param));
        // A macro string maps to a command object that creates a MacroCommand implementation
        commandMap.put("algebraic-macro", param -> {
            ArrayList<UserCommand> macroCommands = new ArrayList<>();
            macroCommands.add(new FormatCommand(treeOps, "in-order"));
            macroCommands.add(new AlgebraicExprCommand(treeOps, param));
            macroCommands.add(new EvalCommand(treeOps, "post-order"));

            return new MacroCommand(treeOps, macroCommands);
        });
        // A macro string maps to a command object that creates a MacroCommand implementation
        commandMap.put("boolean-macro", param -> {
            ArrayList<UserCommand> macroCommands = new ArrayList<>();
            macroCommands.add(new FormatCommand(treeOps, "in-order"));
            macroCommands.add(new BooleanExprCommand(treeOps, param));
            macroCommands.add(new EvalCommand(treeOps, "post-order"));

            return new MacroCommand(treeOps, macroCommands);
        });
    }

    /**
     * This interface uses the Command pattern to create UserCommand implementations at runtime
     */
    private static interface IUserCommandFactoryCommand {
        public UserCommand execute(String param);
    }

    public UserCommand makeUserCommand(String inputString) {
        String parameters = "";
        String commandRequest = inputString;

        int spacePos = inputString.indexOf(' ');

        if (spacePos >= 0) {
            parameters = inputString.substring(spacePos + 1);
            commandRequest = inputString.substring(0, spacePos);
        }

        // Try to find the pre-allocated factory command
        IUserCommandFactoryCommand command = commandMap.get(commandRequest);

        // If command found, execute it, otherwise user gave unknown request, so quit
        if (command != null) {
            return command.execute(parameters);
        }
        else {
            throw new IllegalArgumentException("Unknown request");
        }
    }
}
