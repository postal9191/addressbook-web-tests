package ru.tsqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstName")
    private String firstName;

    @Expose
    @Column(name = "lastName")
    private String lastName;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "middleName")
    private String middleName;

    @Expose
    @Column(name = "nickName")
    private String nickName;

    @Expose
    @Column(name = "company")
    private String company;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String telHome;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String telMobile;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String telWork;

    @Expose
    @Column(name = "fax")
    @Type(type = "text")
    private String fax;

    @Expose
    @Transient
    private String groupName;

    @Expose
    @Transient
    private String allPhones;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Column(name = "phone2")
    @Type(type = "text")
    private String secondaryHome;

    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

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

    public ContactData(int id, String firstName, String lastName, String telHome, String telMobile, String telWork) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telHome = telHome;
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

    public File getPhoto() {
        if(photo != null){
            return new File(photo);
        }
        return null;
    }

    public ContactData setPhoto(File photo) {
        this.photo = photo.getPath();
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
                ", address='" + address + '\'' +
                ", middleName='" + middleName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", company='" + company + '\'' +
                ", telHome='" + telHome + '\'' +
                ", telMobile='" + telMobile + '\'' +
                ", telWork='" + telWork + '\'' +
                ", fax='" + fax + '\'' +
                ", groupName='" + groupName + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", secondaryHome='" + secondaryHome + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public ContactData setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ContactData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
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

    public ContactData setTelHome(String telHome) {
        this.telHome = telHome;
        return this;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public ContactData setTelMobile(String telMobile) {
        this.telMobile = telMobile;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public ContactData setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}
