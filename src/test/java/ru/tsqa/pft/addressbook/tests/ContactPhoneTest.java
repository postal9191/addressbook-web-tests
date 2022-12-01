package ru.tsqa.pft.addressbook.tests;

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
        if (app.db().contacts().size() == 0) {
            app.goTo().groupPage();
            if (app.db().groups().size() == 0) {
                app.group().create(new GroupData("test10", "test2", "test3"));
            }
            app.contact().addContact(new ContactData("Vladislav", "Suvorov", "pupkin",
                    "POSTAL", "сегодня такой www.leningradspb.ru", "Google",
                    "112", "9379992", "6547", "Mail@mail.ru", "test10"));
        }
    }

    @Test
    public void testAddContact() {
        app.goTo().gotoHomePage();
        ContactData contact = app.db().contacts().iterator().next();
        System.out.println(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        System.out.println(contactInfoFromEditForm);

        //assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm))); //не проверяем так как еще не умеем читать контакты с DB
        assertThat(contact.getEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
        //assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm))); //не требуется переводить в список и конвертировать обратно.
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

        verifyContactListInUI();
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getTelHome(), contact.getTelMobile(), contact.getTelWork(), contact.getSecondaryHome())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
