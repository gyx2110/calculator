package calculator.command;

import calculator.Calculator;

import java.util.function.Consumer;

public class EqualCommand implements Command {

    private Calculator calculator;
    private Consumer<String> consumer;

    public EqualCommand(Calculator calculator, Consumer<String> consumer) {
        this.calculator = calculator;
        this.consumer = consumer;
    }

    @Override
    public void execute() {
        String value = calculator.getDisplayValue();
        calculator.getHistoryCommands().clear();
        calculator.getValueStack().clear();
        calculator.setCurrentValue(0d);
        calculator.getValueStack().push(0d);
        consumer.accept(value);
    }
}