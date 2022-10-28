package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class AddContactTest extends TestBase {

    @Test
    public void testAddContact() {
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillContact(new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "telo"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnHomePage();
    }

    @Test
    public void testEditContact() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillContact(new ContactData("Vova", "Pupkin", "4ij", "Ya",
                "1322", "324", "Mailsa@mail.ru", null));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();

    }
}