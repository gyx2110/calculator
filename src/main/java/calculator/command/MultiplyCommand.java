package calculator.command;

import calculator.Calculator;

public class MultiplyCommand implements Command {
    private double value;
    private Calculator calculator;

    public MultiplyCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() * value);
    }
}