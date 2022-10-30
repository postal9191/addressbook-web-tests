package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DelGroupTest extends TestBase {

    @Test
    public void testDelGroup() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }

}