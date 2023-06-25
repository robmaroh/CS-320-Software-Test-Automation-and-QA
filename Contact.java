/*
 * Author Rob Marlatt
 * SNHU
 * 05/21/2023
 */

public class Contact {

  private static final int CONTACT_PHONENUMBER_LENGTH = 10;
  private static final byte CONTACT_IDNUMBER_LENGTH = 10;
  private static final byte CONTACT_FIRSTNAME_LENGTH = 10;
  private static final byte CONTACT_LASTNAME_LENGTH = 10;
  private static final byte CONTACT_ADDRESS_LENGTH = 30;
  private static final String INITIALIZER = "INITIALIZE";
  private static final String INITIALIZER_NUMBER = "1234567890";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  Contact() {
    this.contactId = INITIALIZER;
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUMBER;
    this.address = INITIALIZER;
  }

  Contact(String contactId) {
    updateContactId(contactId);
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUMBER;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUMBER;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNumber = INITIALIZER_NUMBER;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNumber) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNumber, String address) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(address);
  }

  protected final String getContactId() { return contactId; }

  protected final String getFirstName() { return firstName; }

  protected final String getLastName() { return lastName; }

  protected final String getPhoneNumber() { return phoneNumber; }

  protected final String getAddress() { return address; }

  protected void updateFirstName(String firstName) {
    if (firstName == null) {
      throw new IllegalArgumentException("The first name must not be empty");
    } else if (firstName.length() > CONTACT_FIRSTNAME_LENGTH) {
      throw new IllegalArgumentException("The first name must not be more than " +
                                         CONTACT_FIRSTNAME_LENGTH + " characters");
    } else {
      this.firstName = firstName;
    }
  }

  protected void updateLastName(String lastName) {
    if (lastName == null) {
      throw new IllegalArgumentException("The last name must not be empty");
    } else if (lastName.length() > CONTACT_LASTNAME_LENGTH) {
      throw new IllegalArgumentException("The last name must not be more than " +
                                         CONTACT_LASTNAME_LENGTH + " characters");
    } else {
      this.lastName = lastName;
    }
  }

  protected void updatePhoneNumber(String phoneNumber) {
    String regex = "[0-9]+";
    if (phoneNumber == null) {
      throw new IllegalArgumentException("The phone number must not be empty.");
    } else if (phoneNumber.length() != CONTACT_PHONENUMBER_LENGTH) {
      throw new IllegalArgumentException(
          "The phone number length is not correct. Make sure it is " +
          CONTACT_PHONENUMBER_LENGTH + " numbers.");
    } else if (!phoneNumber.matches(regex)) {
      throw new IllegalArgumentException(
          "The phone number must only be numbers");
    } else {
      this.phoneNumber = phoneNumber;
    }
  }

  protected void updateAddress(String address) {
    if (address == null) {
      throw new IllegalArgumentException("The address must be complete");
    } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
      throw new IllegalArgumentException("Address must not be more than " +
                                         CONTACT_ADDRESS_LENGTH +
                                         " characters");
    } else {
      this.address = address;
    }
  }

  protected void updateContactId(String contactId) {
    if (contactId == null) {
      throw new IllegalArgumentException("Contact ID cannot be empty");
    } else if (contactId.length() > CONTACT_IDNUMBER_LENGTH) {
      throw new IllegalArgumentException("Contact ID cannot be longer than " +
                                         CONTACT_IDNUMBER_LENGTH + " characters");
    } else {
      this.contactId = contactId;
    }
  }
}
