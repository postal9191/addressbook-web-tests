package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.tsqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        app.getSessionHelper().logoutAddressBook();
    }
}
