package services.SoapHelper;

import dto.Courses.CourseDTO;
import io.restassured.RestAssured;
import services.RestHelper.AbsBaseRestClient;
import java.util.List;

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
