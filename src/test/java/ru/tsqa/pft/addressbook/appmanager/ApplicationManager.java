package ru.tsqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.tsqa.pft.addressbook.model.ContactData;

import java.time.Duration;

public class ApplicationManager {

    ChromeDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\105\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void logoutAddressBook() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void editContact() {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void updateContact() {
        wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }

    public void fillContact(ContactData contactData) {

        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getTelHome());
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getTelMobile());
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        group(contactData);
    }

    private void group(ContactData contactData) {
        if (contactData.getGroupName() != null) {
            wd.findElement(By.name("new_group")).click();
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
        }
    }

    public void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
