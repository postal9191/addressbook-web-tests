package ru.tsqa.pft.addressbook.model;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nickName;
    private String company;
    private String telHome;
    private String telMobile;
    private String email;
    private String groupName;

    public ContactData(String firstName, String lastName, String middleName, String nickName, String company, String telHome, String telMobile, String email, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.company = company;
        this.telHome = telHome;
        this.telMobile = telMobile;
        this.email = email;
        this.groupName = groupName;
    }

    public ContactData(int id, String firstName, String lastName, String middleName, String nickName, String company, String telHome, String telMobile, String email, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.company = company;
        this.telHome = telHome;
        this.telMobile = telMobile;
        this.email = email;
        this.groupName = groupName;
    }

    public ContactData(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCompany() {
        return company;
    }

    public String getTelHome() {
        return telHome;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
