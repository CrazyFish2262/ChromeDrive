import Postman.Pets;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APItest {
    @Test
    public void first() {
     Pets[] pets =  given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/")
                .when()
                .get("pet/findByStatus?status=sold")
                .body()
                .as(Pets[].class);

     for(int i = 0; i < pets.length; i++){
         System.out.println(pets[i].toJson());
     }

    }
}
