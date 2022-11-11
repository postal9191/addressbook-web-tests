package ru.tsqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;

public class DelGroupTest extends TestBase {

    @Test
    public void testDelGroup() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
