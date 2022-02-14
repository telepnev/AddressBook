package ru.addressbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateGroup {
    private WebDriver wb;
    private WebDriverWait driverWait;


    @BeforeEach
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        wb = new ChromeDriver();
        login("admin", "secret");


    }

    private void login(String login, String password) {
        wb.get("http://localhost/addressbook/");
        wb.findElement(By.name("user")).click();
        wb.findElement(By.name("user")).clear();
        wb.findElement(By.name("user")).sendKeys(login);
        wb.findElement(By.name("pass")).clear();
        wb.findElement(By.name("pass")).sendKeys(password);
        wb.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testUntitledTestCase() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Test2", "Test2", "Test2"));
        submitGroupCreation();
        returnToGroupPage();
    }

    private void returnToGroupPage() {
        wb.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        wb.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wb.findElement(By.name("group_name")).click();
        wb.findElement(By.name("group_name")).clear();
        wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wb.findElement(By.name("group_header")).click();
        wb.findElement(By.name("group_header")).clear();
        wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wb.findElement(By.name("group_footer")).click();
        wb.findElement(By.name("group_footer")).clear();
        wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        wb.findElement(By.name("new")).click();
    }

    private void gotoGroupPage() {
        wb.findElement(By.linkText("groups")).click();
    }

    @AfterEach
    public void tearDown() throws Exception {
        wb.quit();
    }

    private boolean isAlertPresent() {
        try {
            wb.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
