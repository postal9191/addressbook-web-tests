package ru.tsqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.By;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.tsqa.pft.addressbook.model.ContactData;
import ru.tsqa.pft.addressbook.model.Contacts;
import ru.tsqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        xstream.allowTypes(new Class[]{ContactData.class});// в лекции данной строки нет, но без нее не работают тесты
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); // List<GroupData.class> тоже самое
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @BeforeMethod
    public void precondition() {
        app.goTo().groupPage();
        if (!app.isElementPresent(By.xpath("//*[@title='Select (test10)']"))) {
            app.group().create(new GroupData("test10", "test2", "test3"));
        }
    }

    @Test
    public void testAddContact() {
        File photo = new File("src/test/resources/cat.jpg");
        ContactData contact = new ContactData().setFirstName("Pupkin").setLastName("Makar").setEmail("sad@sad").setEmail3("saad@saad").setPhoto(photo);

        app.goTo().gotoHomePage();
        Contacts before = app.contact().allContact();
        app.contact().addContact(contact);
        Contacts after = app.contact().allContact();

        System.out.println(after);

        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact.setId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testAddContactJsonOrXml(ContactData contact) {
        /*ContactData contact = new ContactData("Vladislav", "Suvorov", "pupkin", "POSTAL","сегодня такой www.leningradspb.ru", "Google",
                "112", "9379992","6547", "Mail@mail.ru", "test10");*/
        //File photo = new File("src/test/resources/cat.jpg");
        // ContactData contact = new ContactData().setFirstName("Pupkin").setLastName("Makar").setPhoto(photo);

        app.goTo().gotoHomePage();
        Contacts before = app.contact().allContact();
        app.contact().addContact(contact);
        Contacts after = app.contact().allContact();

        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact.setId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
        //assertThat(after, CoreMatchers.equalTo(before));
    }

    @Test(enabled = false)
    public void testCurrentDir () {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/cat.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}