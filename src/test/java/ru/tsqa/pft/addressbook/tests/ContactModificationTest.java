package ru.tsqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.GroupData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testEditContact() {
        ContactData contact = new ContactData("Vladislav", "Suvorov", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");
        ContactData contactEdit = new ContactData("Vlad", "Suvor", "POSTAL", "Google",
                "112", "9992", "Mail@mail.ru", null);

        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoGroupPage();
            if (!app.isElementPresent(By.xpath(String.format("//*[@title='Select (%s)']", contact.getGroupName())))) {
                app.getGroupHelper().createGroup(new GroupData("test10", "test2", "test3"));
            }
            app.getContactHelper().addContact(contact);
        }
        app.getContactHelper().editContact();
        app.getContactHelper().fillContact(contactEdit, false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();

    }
}
