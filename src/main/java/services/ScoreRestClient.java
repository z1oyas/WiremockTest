package services;

import dto.Score.ScoreDTO;
import dto.User.UserDTO;
import io.restassured.RestAssured;
import java.util.List;

public class ScoreRestClient extends AbsBaseRestClient {

  public ScoreDTO getUserScore(int id){
   return RestAssured.given(requestSpecification())
        .when()
        .get("/user/get/"+ id)
        .then()
              .spec(responseSpecification())
               .log().all()
              .extract().as(ScoreDTO.class);
  }
}
