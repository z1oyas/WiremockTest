package modules;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import services.CourseRestClient;
import services.ScoreRestClient;
import services.UserRestClient;

public class RestClientModule  extends AbstractModule {

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
}
