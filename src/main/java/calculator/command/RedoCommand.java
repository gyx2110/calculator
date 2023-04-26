package calculator.command;

import calculator.Calculator;

import java.util.Stack;

public class RedoCommand implements Command {

    private Calculator calculator;

    public RedoCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        //优先取 undo stack 里的指令
        Stack<Command> undoCommands = calculator.getUndoCommands();
        if (!undoCommands.isEmpty()) {
            undoCommands.pop().execute();
            return;
        }
        //否则 重新执行最近的一条command
        Stack<Command> historyCommands = calculator.getHistoryCommands();
        if (historyCommands.isEmpty()) {
            return;
        }
        historyCommands.peek().execute();
    }
}