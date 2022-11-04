package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;

public class DelGroupTest extends TestBase {

    @Test
    public void testDelGroup() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }

}
