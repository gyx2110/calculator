package calculator.command;

import calculator.Calculator;

import java.util.Stack;

public class UndoCommand implements Command {
    private Calculator calculator;

    public UndoCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        Stack<Command> historyCommands = calculator.getHistoryCommands();
        if (historyCommands.isEmpty()) {
            return;
        }
        Stack<Double> valueStack = calculator.getValueStack();
        if (valueStack.size() <= 1) {
            return;
        }
        Command command = historyCommands.pop();
        Stack<Command> undoCommands = calculator.getUndoCommands();
        undoCommands.push(command);
        valueStack.pop();
        calculator.setCurrentValue(valueStack.peek());
    }
}