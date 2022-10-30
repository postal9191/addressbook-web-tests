package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DelContactTest extends TestBase {

    @Test
    public void delContactTest() {
        app.getContactHelper().selectContact();
        app.getContactHelper().delContact();
        app.getSessionHelper().closeAlert();
        app.getSessionHelper().logoutAddressBook();
    }
}
