package soap;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import extendtions.APIExtentions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.soaphelper.CourseSoapClient;
import services.soaphelper.ScoreSoapClient;
import services.soaphelper.UserSoapClient;
import validators.SoapXMLValidator;

@ExtendWith(APIExtentions.class)
public class SoapApiTest {

  @Inject
  private SoapXMLValidator soapValidator;

  @Inject
  private Faker faker;

  @Inject
  private UserSoapClient userSoapClient;

  @Inject
  private CourseSoapClient courseSoapClient;

  @Inject
  private ScoreSoapClient scoreSoapClient;

  @Test
  public void testGetAllCoursesSoap() {
    String requestBody = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
                               + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                               + "   <soapenv:Body>\n"
                               + "      <GetCourses/>\n"
                               + "   </soapenv:Body>\n"
                               + "</soapenv:Envelope>";

    String response = courseSoapClient.getAllCoursesSoap(requestBody);
    System.out.println("Thread: " + Thread.currentThread().getName());
    assertTrue(soapValidator.isValid("Course/soap-envelope.xsd",response));

  }

  @Test
  public void testGetUserScoreSoap() {
    int randomId = faker.number().numberBetween(1, 100);
    String requestBody = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
                             + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                             + "   <soapenv:Body>\n"
                             + "      <GetUser/>\n"
                             + "   </soapenv:Body>\n"
                             + "</soapenv:Envelope>";

    String response = scoreSoapClient.getUserScoreSoap(requestBody, randomId);
    System.out.println("Thread: " + Thread.currentThread().getName());
    assertTrue(soapValidator.isValid("UserScore/soap-envelope.xsd",response));
    System.out.println("test puling");
  }

  @Test
  public void testGetAllUsersSoap() {
    String requestBody = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
                             + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                             + "   <soapenv:Body>\n"
                             + "      <GetAllUsers/>\n"
                             + "   </soapenv:Body>\n"
                             + "</soapenv:Envelope>";

    String response = userSoapClient.getAllUsersSoap(requestBody);
    System.out.println("Thread: " + Thread.currentThread().getName());
    assertTrue(soapValidator.isValid("UserAllUsers/soap-envelope.xsd",response));

  }
}
