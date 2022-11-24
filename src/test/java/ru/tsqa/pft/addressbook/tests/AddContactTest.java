package ru.tsqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.Contacts;
import ru.tsqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.goTo().groupPage();
        if (!app.isElementPresent(By.xpath("//*[@title='Select (test10)']"))) {
            app.group().create(new GroupData("test10", "test2", "test3"));
        }
    }

    @Test
    public void testAddContact() {
        /*ContactData contact = new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL","сегодня такой www.leningradspb.ru", "Google",
                "112", "9379992","6547", "Mail@mail.ru", "test10");*/
        File photo = new File("src/test/resources/cat.jpg");
        ContactData contact = new ContactData().setFirstName("Pupkin").setLastName("Makar").setPhoto(photo);

        app.goTo().gotoHomePage();
        Contacts before = app.contact().allContact();
        app.contact().addContact(contact);
        Contacts after = app.contact().allContact();

        assertEquals(after.size(), before.size() + 1);
        assertThat(after, CoreMatchers.equalTo(
                before.withAdded(contact.setId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testCurrentDir () {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/cat.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}