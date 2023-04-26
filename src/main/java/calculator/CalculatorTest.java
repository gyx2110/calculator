package calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //5 * 3 * 2 / 2 - 1 = 14
        calculator.pressAddCommand(5);
        calculator.pressMultiplyCommand(3.0);
        calculator.pressMultiplyCommand(2.0);
        calculator.pressDivideCommand(2.0);
        calculator.pressSubtractCommand(1.0);
        System.out.println(calculator.getDisplayValue()); //14

        //全部 undo 掉
        calculator.pressUndoCommand();
        calculator.pressUndoCommand();
        calculator.pressUndoCommand();
        calculator.pressUndoCommand();
        calculator.pressUndoCommand();
        System.out.println(calculator.getDisplayValue());  // 0

        //挨个redo
        calculator.pressRedoCommand();
        calculator.pressRedoCommand();
        calculator.pressRedoCommand();
        calculator.pressRedoCommand();
        calculator.pressRedoCommand();

        calculator.pressEqualCommand(System.out::println); //14
    }
}
