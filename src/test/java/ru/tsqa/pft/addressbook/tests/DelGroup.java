package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DelGroup extends TestBase {

    @Test
    public void testDelGroup() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnGroupPage();
    }

}
