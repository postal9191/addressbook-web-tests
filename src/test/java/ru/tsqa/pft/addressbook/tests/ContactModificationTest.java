package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testEditContact() {
        ContactData contact = new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");
        ContactData contactEdit = new ContactData("Vlad", "Suvor", "POSTAL", "Google",
                "112", "9992", "Mail@mail.ru", "test10");

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().addContact(contact);
        }
        app.getContactHelper().editContact();
        app.getContactHelper().fillContact(contactEdit, false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();

    }
}
