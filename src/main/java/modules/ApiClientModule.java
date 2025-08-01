package modules;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import services.RestHelper.CourseRestClient;
import services.RestHelper.ScoreRestClient;
import services.RestHelper.UserRestClient;
import validators.SoapXMLValidator;

public class ApiClientModule extends AbstractModule {

  @Provides
  @Singleton
  public UserRestClient getUserRestClient() {
    return new UserRestClient();
  }

  @Provides
  @Singleton
  public ScoreRestClient getScoreRestClient() {
    return new ScoreRestClient();
  }

  @Provides
  @Singleton
  public CourseRestClient getCourseRestClient() {
    return new CourseRestClient();
  }

  @Provides
  @Singleton
  public Faker getFaker() {
    return new Faker();
  }

  @Provides
  @Singleton
  public SoapXMLValidator getSoapXMLValidator() {
    return new SoapXMLValidator();
  }
}
