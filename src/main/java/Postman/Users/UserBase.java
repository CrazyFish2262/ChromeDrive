package Postman.Users;

import java.util.Date;

public class UserBase {
    public String name;
    public String job;
    public String id;
    public String createdAt;



    public UserBase(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UserBase(){}

}
