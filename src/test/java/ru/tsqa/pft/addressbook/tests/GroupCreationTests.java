package ru.tsqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.GroupData;
import ru.tsqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withName("test1").withHeader("test1").withFooter("test1")});
        list.add(new Object[]{new GroupData().withName("test2").withHeader("test2").withFooter("test2")});
        list.add(new Object[]{new GroupData().withName("test3").withHeader("test3").withFooter("test3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();

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
