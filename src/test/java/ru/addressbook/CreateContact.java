package ru.addressbook;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateContact extends TestBase{

    @Test
    public void testCreateContact()  {


        initCreationContact();
        fillContactForm(new ContactDate("Telepnef", "Evgeny", "Sibintec", "Moscow", "+7926 522 4333", "8903 562 23 23", "telepnef@yandex.ru"));
        wb.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        returnToHomePage();
    }

}
