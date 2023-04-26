package calculator.command;

import calculator.Calculator;

public class AddCommand implements Command {
    private double value;
    private Calculator calculator;

    public AddCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() + value);
    }
}