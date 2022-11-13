package ru.tsqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testEditContact() {
        ContactData contact = new ContactData("Vladislav", "Suvorov","pupkin", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");

        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoGroupPage();
            if (!app.isElementPresent(By.xpath(String.format("//*[@title='Select (%s)']", contact.getGroupName())))) {
                app.getGroupHelper().createGroup(new GroupData("test10", "test2", "test3"));
            }
            app.getContactHelper().addContact(contact);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        ContactData contactEdit = new ContactData(before.get(before.size() - 1).getId(),"Vlad", "Suvor","pupkin", "POSTAL", "Google",
                "112", "9992", "Mail@mail.ru", null);
        app.getContactHelper().fillContact(contactEdit, false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contactEdit);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
