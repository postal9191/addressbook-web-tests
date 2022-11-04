package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        GroupData fillForm = new GroupData("test10", "test20", "test30");

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(fillForm);
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(fillForm);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
    }
}
