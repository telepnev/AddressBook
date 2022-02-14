package ru.addressbook;

public class ContactDate {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
    private final String email;

    public ContactDate(String firstName, String lastName, String company, String address, String homePhone, String mobilePhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }
}
