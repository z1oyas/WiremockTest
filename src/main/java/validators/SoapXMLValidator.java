package validators;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

public class SoapXMLValidator {
  private Validator initValidaor(String path) {
  SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
  //Source schemaFile = new StreamSource("src/main/resources/schemas/soap/"+path);
    Source[] schemas = {
        new StreamSource("src/main/resources/schemas/soap/"+path)
    };
  try {
  Schema schema = factory.newSchema(schemas);
    return schema.newValidator();
}
  catch (SAXException e)
  {
    e.printStackTrace();
  }
    return null;
  }

  public  boolean isValid(String path, String file) {
    Validator validator = initValidaor(path);
    try {
      validator.validate(new StreamSource(new StringReader(file)));
      return true;
    } catch (SAXException | IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
