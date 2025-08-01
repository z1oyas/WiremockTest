package extendtions;

import com.google.inject.Guice;
import modules.RestClientModule;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class APIExtentions implements BeforeEachCallback {

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    Guice.createInjector(new RestClientModule()).injectMembers(context.getTestInstance().orElseThrow());
  }
}
