package ru.tsqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {

    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String middleName;
    @Expose
    private String nickName;
    @Expose
    private String company;
    @Expose
    private String telHome;
    @Expose
    private String telMobile;
    @Expose
    private String telWork;
    @Expose
    private String fax;
    @Expose
    private String groupName;
    @Expose
    private String allPhones;
    @Expose
    private String email;
    @Expose
    private String address;
    @Expose
    private String email2;
    @Expose
    private String secondaryHome;
    @Expose
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getSecondaryHome() {
        return secondaryHome;
    }

    public ContactData setSecondaryHome(String secondaryHome) {
        this.secondaryHome = secondaryHome;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public ContactData setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData setEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData setEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    private String email3;

    public String getEmail() {
        return email;
    }

    public ContactData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactData setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData setAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData(String firstName, String lastName, String middleName, String nickName, String address, String company, String telHome, String telMobile, String telWork, String email, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.address = address;
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

    public ContactData() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
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
