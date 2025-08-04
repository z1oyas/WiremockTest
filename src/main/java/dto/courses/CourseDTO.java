package dto.courses;

public class CourseDTO {
  private  String name;
  private  String price;

  public CourseDTO() {}

  public CourseDTO(String name, String price) {
    this.name = name;
    this.price = price;
  }

  public String getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
