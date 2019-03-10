package fr.epsi.demo.bean;

public class Contact {

  private Long identifier;
  
  private String firstName;
  
  private String lastName;
  
  private String phoneNumber;

  public Long getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Long identifier) {
    this.identifier = identifier;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Contact [identifier=" + identifier + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
  }
  
  
}
