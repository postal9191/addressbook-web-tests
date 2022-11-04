package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class AddContactTest extends TestBase {

    @Test
    public void testAddContact() {
        ContactData contact = new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");

        app.getContactHelper().addContact(contact, true);
    }

}