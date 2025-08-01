package services.RestHelper;

import dto.Score.ScoreDTO;
import io.restassured.RestAssured;

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
