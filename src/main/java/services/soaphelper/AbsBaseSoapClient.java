package services.soaphelper;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class AbsBaseSoapClient {

  static {
    RestAssured.defaultParser = Parser.XML;
  }

  protected RequestSpecification requestSpecification(){
    return RestAssured.given()
               .baseUri(System.getProperty("base.url"))
               .basePath("/wiremock")
               .header("Content-Type", "text/xml");
  }

  protected ResponseSpecification responseSpecification(){
    return RestAssured.given().then().statusCode(200);
  }
}

