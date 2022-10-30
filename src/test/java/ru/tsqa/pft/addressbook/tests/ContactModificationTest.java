package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

    @Test
    public void testEditContact() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillContact(new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", null));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();

    }
}
