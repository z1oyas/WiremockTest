package dto.Score;

public class ScoreDTO {
  private  String score;
  private  String name;

  public ScoreDTO() {}

  public ScoreDTO(String score, String name) {
    this.score = score;
    this.name = name;
  }

  public String getScore() {
    return score;
  }

  public String getName() {
    return name;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public void setName(String name) {
    this.name = name;
  }
}
