package dto.user;

public class UserDTO {
  private  String name;
  private  String cource;
  private String email;
  private  int age;

  public UserDTO() {}

  public UserDTO(String name, String course, String mail, int age) {
    this.name = name;
    this.cource = course;
    this.email = mail;
    this.age = age;
  }

  public String getCource() {
    return cource;
  }

  public String getName() {
    return name;
  }

  public String getMail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public void setCource(String cource) {
    this.cource = cource;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
