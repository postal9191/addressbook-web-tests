package ru.tsqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String nickName;
    private final String company;
    private final String telHome;
    private final String telMobile;
    private final String email;
    private final String groupName;

    public ContactData(String firstName, String middleName, String nickName, String company, String telHome, String telMobile, String email, String groupName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.company = company;
        this.telHome = telHome;
        this.telMobile = telMobile;
        this.email = email;
        this.groupName = groupName;
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
}
