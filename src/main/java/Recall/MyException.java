package Recall;

public class MyException extends Exception {

    String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        System.out.println("There is an error. Please, try again");
        return message;
    }
}
