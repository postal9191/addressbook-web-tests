package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class DelContactTest extends TestBase {

    @Test
    public void delContactTest() {
        ContactData contact = new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");

        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().addContact(contact);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().delContact();
        app.getSessionHelper().closeAlert();
        app.getSessionHelper().logoutAddressBook();
    }
}
