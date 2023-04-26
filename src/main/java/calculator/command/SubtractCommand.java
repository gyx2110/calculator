package calculator.command;

import calculator.Calculator;

public class SubtractCommand implements Command {
    private double value;
    private Calculator calculator;

    public SubtractCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() - value);
    }
}