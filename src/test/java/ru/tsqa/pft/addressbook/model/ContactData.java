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
    private String telWork;
    private String email;
    private String groupName;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData setAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    private String allPhones;

    public ContactData(String firstName, String lastName, String middleName, String nickName, String company, String telHome, String telMobile, String telWork, String email, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.company = company;
        this.telHome = telHome;
        this.telMobile = telMobile;
        this.telWork = telWork;
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

    public ContactData(int id, String firstName, String lastName, String telHome, String telMobile,String telWork) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telHome =telHome;
        this.telMobile = telMobile;
        this.telWork = telWork;
    }

    public ContactData(int id, String firstName, String lastName, String allPhones) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.allPhones = allPhones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (telHome != null ? !telHome.equals(that.telHome) : that.telHome != null) return false;
        if (telMobile != null ? !telMobile.equals(that.telMobile) : that.telMobile != null) return false;
        return telWork != null ? telWork.equals(that.telWork) : that.telWork == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (telHome != null ? telHome.hashCode() : 0);
        result = 31 * result + (telMobile != null ? telMobile.hashCode() : 0);
        result = 31 * result + (telWork != null ? telWork.hashCode() : 0);
        return result;
    }

    public ContactData() {
    }

    public ContactData setId(int id) {
        this.id = id;
        return this;
    }

    public ContactData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData setTelHome(String telHome) {
        this.telHome = telHome;
        return this;
    }

    public ContactData setTelMobile(String telMobile) {
        this.telMobile = telMobile;
        return this;
    }

    public String getTelWork() {
        return telWork;
    }

    public ContactData setTelWork(String telWork) {
        this.telWork = telWork;
        return this;
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

    public ContactData setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getLastName() {
        return lastName;
    }

}
