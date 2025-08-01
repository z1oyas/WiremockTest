package services.SoapHelper;

import dto.Score.ScoreDTO;
import io.restassured.RestAssured;
import services.RestHelper.AbsBaseRestClient;

public class ScoreSoapClient extends AbsBaseSoapClient {

  public String getUserScoreSoap(String soapBody, int id){
   return RestAssured.given(requestSpecification())
              .body(soapBody)
              .log().all()
              .when()
              .post("/soap/user/get/"+ id)
              .then()
              .spec(responseSpecification())
              .log().all()
              .extract().asString();
  }
}
