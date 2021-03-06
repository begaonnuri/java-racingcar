package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operand;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApp {
    public static void main(String[] args) {
        String inputExpression = InputView.inputExpression();
        System.out.println(inputExpression);

        Calculator calculator = new Calculator();
        Operand result = calculator.run(inputExpression);

        OutputView.printResult(result);
    }
}
