package Recall;

public class MyException extends Exception {

    public MyException(String message) {
        this.message = message;
    }

    String message;

    @Override
    public String getMessage() {
        System.out.println("There is an error. Please, try again");
        return message;
    }
}
