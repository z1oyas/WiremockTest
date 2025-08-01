package extendtions;

import com.google.inject.Guice;
import modules.ApiClientModule;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class APIExtentions implements BeforeEachCallback {

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    Guice.createInjector(new ApiClientModule()).injectMembers(context.getTestInstance().orElseThrow());
  }
}
