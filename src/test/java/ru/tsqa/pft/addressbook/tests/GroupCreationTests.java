package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;
import ru.tsqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.group().create(group);

        assertThat(app.group().count(), equalTo(before.size() + 1));

        Groups after = app.group().all();

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData("test1'", "test2", "test3");
        app.group().create(group);

        assertThat(app.group().count(), equalTo(before.size()));

        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before));
    }
}
