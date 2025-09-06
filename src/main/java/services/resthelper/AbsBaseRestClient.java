package services.resthelper;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class AbsBaseRestClient {

  static {
    RestAssured.defaultParser = Parser.JSON;
  }

  protected RequestSpecification requestSpecification(){
    return RestAssured.given()
               .baseUri(System.getProperty("base_url", "http://127.0.0.1"))
               .basePath("/wiremock");
  }

  protected ResponseSpecification responseSpecification(){
    return RestAssured.given().then().statusCode(200);
  }
}

