package at.fhv.quickhotel.domain.modelInterface;

public interface IContact {
    int getContactID();

    void setContactID(int contactID);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getStreet();

    void setStreet(String street);

    String getPlace();

    void setPlace(String place);

    String getPostcode();

    void setPostcode(String postcode);

    String getCountry();

    void setCountry(String country);

    String getEmail();

    void setEmail(String email);

    boolean isActive();

    void setActive(boolean active);
}
