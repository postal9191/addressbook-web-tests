package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;
import ru.tsqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData("test10", "test20", "test30"));
        }
    }

    @Test(enabled = false)
    public void testGroupModificationReadFromUI() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData(modifiedGroup.getId(), "test10", "test20", "test30");
        app.group().modify(group);

        assertThat(app.group().count(), equalTo(before.size()));

        Groups after = app.group().all();

        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }

    @Test
    public void testGroupModificationReadFromDb() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData(modifiedGroup.getId(), "test10", "test20", "test30");
        app.goTo().groupPage();
        app.group().modify(group);

        assertThat(app.group().count(), equalTo(before.size()));

        Groups after = app.db().groups();

        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }
}
