package Postman.Users.Registration;

import java.util.List;

public class RegistrationRoot {
    public String email;
    public String password;

    public RegistrationRoot(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegistrationRoot(String email) {
    }

}
