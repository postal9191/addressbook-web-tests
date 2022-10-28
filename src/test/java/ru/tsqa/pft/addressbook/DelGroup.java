package ru.tsqa.pft.addressbook;

import org.testng.annotations.Test;

public class DelGroup extends TestBase {

    @Test
    public void testDelGroup() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnGroupPage();
    }

}
