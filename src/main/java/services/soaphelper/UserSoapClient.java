package services.soaphelper;

import io.restassured.RestAssured;

public class UserSoapClient extends AbsBaseSoapClient {

  public String getAllUsersSoap(String body) {
    return RestAssured.given(requestSpecification())
              .body(body)
              .log().all()
              .when()
              .post("/soap/user/get/all")
              .then()
              .spec(responseSpecification())
               .log().all()
              .extract().asString();
  }
}
