package ru.tsqa.pft.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddContact {
    private static ChromeDriver wd;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\105\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        stockLink();
        login("admin", "secret");
    }

    @Test
    public void testAddContact() throws Exception {
        addNewContact();
        fillContact(new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru","telo"));
        submitContactCreation();
        returnHomePage();
    }

    @Test
    public void testEditContact() throws Exception {
        editContact();
        fillContact(new ContactData("Vova", "Pupkin", "4ij", "Ya",
                "1322", "324", "Mailsa@mail.ru", null));
        updateContact();
        returnHomePage();

    }

    private void editContact() {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    private void stockLink() {
        wd.get("http://localhost/addressbook/");
    }

    private static void login(String username, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    private void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void updateContact() {
        wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }


    private void fillContact(ContactData contactData) {

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

    private void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }
}