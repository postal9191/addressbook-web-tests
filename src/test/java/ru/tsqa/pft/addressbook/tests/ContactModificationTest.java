package ru.tsqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.Contacts;
import ru.tsqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    private void precondition() {
        if (app.contact().allContact().size() == 0) {
            app.goTo().groupPage();
            if (!app.isElementPresent(By.xpath("//*[@title='Select (test10)']"))) {
                app.group().create(new GroupData("test10", "test2", "test3"));
            }
            app.contact().addContact(new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL", "Google",
                    "112", "9379992", "Mail@mail.ru", "test10"));
        }
    }

    @Test
    public void testEditContact() {
        Contacts before = app.contact().allContact();
        ContactData modifiedContact = before.iterator().next();

        ContactData contactEdit = new ContactData(modifiedContact.getId(), "Vlad", "Suvor", "pupkin", "POSTAL", "Google",
                "112", "9992", "Mail@mail.ru", null);

        app.contact().fillAndUpdateContact(contactEdit);
        Contacts after = app.contact().allContact();

        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contactEdit)));
    }
}
