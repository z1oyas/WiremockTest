package services.resthelper;

import dto.courses.CourseDTO;
import io.restassured.RestAssured;
import java.util.List;

public class CourseRestClient extends AbsBaseRestClient{

  public List<CourseDTO> getAllCourses(){
    return RestAssured.given(requestSpecification())
               .when()
               .get("/course/get/all")
               .then()
               .spec(responseSpecification())
               .log().all()
               .extract().body()
               .jsonPath()
               .getList("", CourseDTO.class);
  }
}
