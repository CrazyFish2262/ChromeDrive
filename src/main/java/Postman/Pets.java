package Postman;

import java.util.List;

public class Pets implements ToJson {
    public Object id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;
}
