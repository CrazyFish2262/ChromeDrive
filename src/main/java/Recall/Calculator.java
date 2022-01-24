package Recall;

public class Calculator {
    double sum(double x, double y) {
        return x + y;
    }

    double sub(double x, double y) {
        return x - y;
    }

    double multi(double x, double y) {
        return x * y;
    }

    double div(double x, double y) throws MyException {
       if (y == 0) {
            try {
                throw new MyException ("Нельзя делить на ноль");
            } catch (MyException exception) {
                exception.getMessage();
            }
        }
        return x / y;
    }
}