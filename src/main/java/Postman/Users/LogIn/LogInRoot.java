package Postman.Users.LogIn;

import Postman.Users.Registration.RegistrationRoot;

public class LogInRoot extends RegistrationRoot {


    public LogInRoot(String email, String password) {
        super(email, password);
    }

    public LogInRoot(String email) {
        super(email);
    }
}
