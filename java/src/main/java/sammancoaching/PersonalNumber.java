package sammancoaching;

public class PersonalNumber {
  private String swedishPersonalNumber;

  public PersonalNumber(String swedishPersonalNumber) {
    swedishPersonalNumber = swedishPersonalNumber.replace("-", "");
    validateLength(swedishPersonalNumber);
    this.swedishPersonalNumber = swedishPersonalNumber;
  }

  public int birthYear() {
    String year = swedishPersonalNumber.substring(0, 4);
    return Integer.parseInt(year);
  }

  private static void validateLength(String swedishPersonalNumber) {
    if (swedishPersonalNumber.length() != 12)
      throw new IllegalArgumentException("invalid personal number " + swedishPersonalNumber);
  }
}
