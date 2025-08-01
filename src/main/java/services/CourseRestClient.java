package services;

import dto.Courses.CourseDTO;
import dto.User.UserDTO;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.codehaus.jackson.map.util.JSONPObject;
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
