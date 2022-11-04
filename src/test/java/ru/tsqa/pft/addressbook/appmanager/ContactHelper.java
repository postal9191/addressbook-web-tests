package ru.tsqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.tsqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void editContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void fillContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getTelHome());
        type(By.name("mobile"), contactData.getTelMobile());
        type(By.name("email"), contactData.getEmail());
        groupInAddContact(contactData, creation);
    }

    private void groupInAddContact(ContactData contactData, boolean creation) {
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void returnHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void delContact() {
        click(By.xpath("//*[@value='Delete']"));
    }

    public void addContact(ContactData contact, boolean creation) {
        clickAddNewContact();
        fillContact(contact, creation);
        submitContactCreation();
        returnHomePage();
    }

    private void clickAddNewContact() {
        click(By.linkText("add new"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
