package user;

import com.github.javafaker.Faker;
import dto.Courses.CourseDTO;
import dto.Score.ScoreDTO;
import dto.User.UserDTO;
import extendtions.APIExtentions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.CourseRestClient;
import services.ScoreRestClient;
import services.UserRestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

@ExtendWith(APIExtentions.class)
public class RestApiTest {

  @Inject
  private Faker faker;

  @Inject
  private UserRestClient userRestClient;

  @Inject
  private CourseRestClient courseRestClient;

  @Inject
  private ScoreRestClient scoreRestClient;

  @Test
  public void testGetAllUsers() throws IOException {
    List<UserDTO> response = userRestClient.getAllUsers();
    UserDTO expectedUser = new UserDTO("Test user","QA", "test@test.test", 23);
    List<UserDTO> expectedUsers = List.of(expectedUser);

    assertEquals(expectedUser.getName(), response.get(0).getName(), "Names are not equal");
    assertEquals(expectedUser.getCourсe(), response.get(0).getCourсe(), "Courses are not equal");
    assertEquals(expectedUser.getMail(), response.get(0).getMail(), "Mails are not equal");
    assertEquals(expectedUser.getAge(), response.get(0).getAge(), "Ages are not equal");
  }

  @Test
  public void testGetUser() throws IOException {

    ScoreDTO userScore = scoreRestClient.getUserScore(faker.number().numberBetween(1, 100));

    ScoreDTO expectedUserScore = new ScoreDTO("78", "Test user");

    assertEquals(expectedUserScore.getName(), userScore.getName(), "Names are not equal");
    assertEquals(expectedUserScore.getScore(), userScore.getScore(), "Courses are not equal");
  }

  @Test
  public void testGetAllCourses() throws IOException {
    List<CourseDTO> response = courseRestClient.getAllCourses();

    CourseDTO expectedCourse = new CourseDTO("QA java", "15000");
    CourseDTO expectedCourse2 = new CourseDTO("Java", "12000");

    List<CourseDTO> expectedCourses = List.of(expectedCourse, expectedCourse2);

    assertEquals(expectedCourses.get(0).getName(), response.get(0).getName(), "Names are not equal");
    assertEquals(expectedCourses.get(0).getPrice(), response.get(0).getPrice(), "Prices are not equal");

    assertEquals(expectedCourses.get(1).getName(), response.get(1).getName(), "Names are not equal");
    assertEquals(expectedCourses.get(1).getPrice(), response.get(1).getPrice(), "Prices are not equal");
  }
}
