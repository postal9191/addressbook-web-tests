package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;

public class AddContact extends TestBase {

    @Test
    public void testAddContact() throws Exception {
        app.addNewContact();
        app.fillContact(new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru","telo"));
        app.submitContactCreation();
        app.returnHomePage();
    }

    @Test
    public void testEditContact() throws Exception {
        app.editContact();
        app.fillContact(new ContactData("Vova", "Pupkin", "4ij", "Ya",
                "1322", "324", "Mailsa@mail.ru", null));
        app.updateContact();
        app.returnHomePage();

    }
}