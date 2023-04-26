package calculator.command;

import calculator.Calculator;

public class DivideCommand implements Command {
    private double value;
    private Calculator calculator;

    public DivideCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        if (value == 0.0) {
            throw new RuntimeException("Cannot divide by zero");
        }
        calculator.setCurrentValue(calculator.getCurrentValue() / value);
    }
}