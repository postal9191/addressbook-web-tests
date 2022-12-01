package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.Contacts;
import ru.tsqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DelContactTest extends TestBase {

    @BeforeMethod
    private void precondition() {
        if (app.db().contacts().size() == 0) {
            app.goTo().groupPage();
            if (app.db().groups().size() == 0) {
                app.group().create(new GroupData("test10", "test2", "test3"));
            }
            app.contact().addContact(new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL", "сегодня такой www.leningradspb.ru", "Google",
                    "112", "9379992", "6547", "Mail@mail.ru", "test10"));
        }
    }

    @Test
    public void delContactTest() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().selectAndDelContact(before);
        app.getSessionHelper().closeAlert();
        app.goTo().gotoHomePage();
        Contacts after = app.db().contacts();
        app.getSessionHelper().logoutAddressBook();

        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deletedContact)));

        verifyContactListInUI();
    }
}
