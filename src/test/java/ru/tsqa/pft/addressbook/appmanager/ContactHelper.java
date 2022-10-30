package ru.tsqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.tsqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
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

    public void fillContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getTelHome());
        type(By.name("mobile"), contactData.getTelMobile());
        type(By.name("email"), contactData.getEmail());
        group(contactData);
    }

    private void group(ContactData contactData) {
        if (contactData.getGroupName() != null) {
            click(By.name("new_group"));
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
        }
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void selectContact() {
        click(By.xpath("//*[@type='checkbox']"));
    }

    public void delContact() {
        click(By.xpath("//*[@value='Delete']"));
    }
}
