package services.RestHelper;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class AbsBaseRestClient {

  public AbsBaseRestClient() {
    RestAssured.defaultParser = Parser.JSON;
  }

  protected RequestSpecification requestSpecification(){
    return RestAssured.given()
               .baseUri(System.getProperty("base.url"))
               .basePath("/wiremock");
  }

  protected ResponseSpecification responseSpecification(){
    return RestAssured.given().then().statusCode(200);
  }
}

