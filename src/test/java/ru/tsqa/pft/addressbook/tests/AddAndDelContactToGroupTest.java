package ru.tsqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.Contacts;
import ru.tsqa.pft.addressbook.model.GroupData;
import ru.tsqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class AddAndDelContactToGroupTest extends TestBase {

    @BeforeMethod
    private void precondition() {
        if (app.db().contacts().size() == 0) {
            app.goTo().groupPage();
            if (app.db().groups().size() == 0) {
                app.group().create(new GroupData("test10", "test2", "test3"));
            }
            app.contact().addContact(new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL", "сегодня такой www.leningradspb.ru", "Google",
                    "112", "9379992", "6547", "Mail@mail.ru", "test10"));
        }
    }

    @Test
    public void testContactAddToGroup() {
        Contacts beforeContact = app.db().contacts();
        ContactData contact = beforeContact.iterator().next();
        Groups beforeGroup = app.db().groups();
        GroupData group = beforeGroup.iterator().next();
        if (!contact.getGroups().isEmpty() && contact.getGroups().contains(group)) {
            app.contact().removeGroup(contact, group);
        }
        Groups beforeLinkedGroup = app.db().contacts().stream().iterator().next().getGroups();
        System.out.println("Группы связанные до " + beforeLinkedGroup);

        app.contact().addToGroup(contact, group);
        Contacts afterContact = app.db().contacts();
        Groups afterGroup = app.db().groups();


        Groups afterLinkedGroup = app.db().contacts().stream().iterator().next().getGroups();
        System.out.println("Группы связанные после " + afterLinkedGroup);

        Assert.assertEquals(afterGroup.size(), beforeGroup.size());
        Assert.assertEquals(afterContact.size(), beforeContact.size());
        assertThat(afterLinkedGroup, equalTo(beforeLinkedGroup.withAdded(group)));
    }

    @Test
    public void testContactRemoveToGroup() {
        Contacts beforeContact = app.db().contacts();
        ContactData contact = beforeContact.iterator().next();
        Groups beforeGroup = app.db().groups();
        GroupData group = beforeGroup.iterator().next();
        if (contact.getGroups().isEmpty()) {
            app.contact().addToGroup(contact, group);
        }
        Groups beforeLinkedGroup = app.db().contacts().stream().iterator().next().getGroups();
        System.out.println("Группы связанные до " + beforeLinkedGroup);

        app.contact().removeGroup(contact, group);
        Contacts afterContact = app.db().contacts();
        Groups afterGroup = app.db().groups();


        Groups afterLinkedGroup = app.db().contacts().stream().iterator().next().getGroups();
        System.out.println("Группы связанные после " + afterLinkedGroup);

        Assert.assertEquals(afterGroup.size(), beforeGroup.size());
        Assert.assertEquals(afterContact.size(), beforeContact.size());
        assertThat(afterLinkedGroup.withAdded(group), equalTo(beforeLinkedGroup));
    }
}
