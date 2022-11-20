package ru.tsqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.GroupData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    private void precondition() {
        if (app.contact().allContact().size() == 0) {
            app.goTo().groupPage();
            if (!app.isElementPresent(By.xpath("//*[@title='Select (test10)']"))) {
                app.group().create(new GroupData("test10", "test2", "test3"));
            }
            app.contact().addContact(new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL", "Google",
                    "112", "9379992", "6547", "Mail@mail.ru", "test10"));
        }
    }

    @Test
    public void testAddContact() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().allContact().iterator().next();
        System.out.println(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        System.out.println(contactInfoFromEditForm);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }
        private String mergePhones (ContactData contact){
            return Arrays.asList(contact.getTelHome(), contact.getTelMobile(), contact.getTelWork())
                    .stream().filter((s) -> !s.equals(""))
                    .map(ContactPhoneTest::cleaned)
                    .collect(Collectors.joining("\n"));
        }

        public static String cleaned (String phone){
            return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
        }
    }
