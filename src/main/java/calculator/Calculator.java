package calculator;

import calculator.command.AddCommand;
import calculator.command.Command;
import calculator.command.DivideCommand;
import calculator.command.EqualCommand;
import calculator.command.MultiplyCommand;
import calculator.command.RedoCommand;
import calculator.command.SubtractCommand;
import calculator.command.UndoCommand;

import java.util.Stack;
import java.util.function.Consumer;

public class Calculator {

    private Stack<Command> historyCommands; //记录历史command
    private Stack<Command> undoCommands;  //记录撤销过的command
    private Stack<Double> valueStack;    //值栈
    private double currentValue;

    public Calculator() {
        currentValue = 0.0;
        undoCommands = new Stack<>();
        valueStack = new Stack<>();
        historyCommands = new Stack<>();
        valueStack.push(0d);
    }

    public void execute(Command command) {
        command.execute();
        if (!(command instanceof UndoCommand)) {
            valueStack.push(currentValue);
        }
        if (!(command instanceof RedoCommand)
                && !(command instanceof UndoCommand)) {
            historyCommands.push(command);
        }
    }

    public String getDisplayValue() {
        long longValue = Double.valueOf(currentValue).longValue();
        if (longValue == currentValue) {
            return String.valueOf(longValue);
        }
        return String.format("%.2f", currentValue);
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public Stack<Command> getHistoryCommands() {
        return historyCommands;
    }

    public Stack<Double> getValueStack() {
        return valueStack;
    }

    public Stack<Command> getUndoCommands() {
        return undoCommands;
    }


    public void pressAddCommand(double value) {
        execute(new AddCommand(this, value));
    }

    public void pressSubtractCommand(double value) {
        execute(new SubtractCommand(this, value));
    }

    public void pressMultiplyCommand(double value) {
        execute(new MultiplyCommand(this, value));
    }

    public void pressDivideCommand(double value) {
        execute(new DivideCommand(this, value));
    }

    public void pressUndoCommand() {
        execute(new UndoCommand(this));
    }

    public void pressRedoCommand() {
        execute(new RedoCommand(this));
    }

    public void pressEqualCommand(Consumer<String> consumer) {
        execute(new EqualCommand(this, consumer));
    }
}

