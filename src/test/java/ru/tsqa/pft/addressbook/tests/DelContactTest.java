package ru.tsqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class DelContactTest extends TestBase {

    @Test(enabled = false)
    public void delContactTest() {
        ContactData contact = new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL", "Google",
                "112", "9379992", "Mail@mail.ru", "test10");

        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoGroupPage();
            if (!app.isElementPresent(By.xpath(String.format("//*[@title='Select (%s)']", contact.getGroupName())))) {
                app.getGroupHelper().createGroup(new GroupData("test10", "test2", "test3"));
            }
            app.getContactHelper().addContact(contact);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().delContact();
        app.getSessionHelper().closeAlert();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        app.getSessionHelper().logoutAddressBook();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
