package services.RestHelper;

import dto.User.UserDTO;
import io.restassured.RestAssured;
import java.util.List;

public class UserRestClient extends AbsBaseRestClient {

  public List<UserDTO> getAllUsers(){
   return RestAssured.given(requestSpecification())
        .when()
        .get("/user/get/all")
        .then()
              .spec(responseSpecification())
               .log().all()
              .extract().body()
              .jsonPath()
              .getList("", UserDTO.class);
  }
}
