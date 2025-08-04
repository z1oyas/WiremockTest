package services.soaphelper;

import io.restassured.RestAssured;

public class CourseSoapClient extends AbsBaseSoapClient {

  public String getAllCoursesSoap(String soapBody){
    return RestAssured.given(requestSpecification())
               .body(soapBody)
               .log().all()
               .when()
               .post("/soap/course/get/all")
               .then()
               .spec(responseSpecification())
               .log().all()
               .extract().asString();
  }
}
