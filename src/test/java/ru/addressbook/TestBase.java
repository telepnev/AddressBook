package ru.addressbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    protected WebDriver wb;
    private WebDriverWait driverWait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        wb = new ChromeDriver();
        login("admin", "secret");


    }


    protected void returnToHomePage() {
        wb.findElement(By.linkText("home page")).click();
    }

    protected void fillContactForm(ContactDate contactDate) {
        wb.findElement(By.name("firstname")).click();
        wb.findElement(By.name("firstname")).clear();
        wb.findElement(By.name("firstname")).sendKeys(contactDate.getFirstName());
        wb.findElement(By.name("lastname")).click();
        wb.findElement(By.name("lastname")).clear();
        wb.findElement(By.name("lastname")).sendKeys(contactDate.getLastName());
        wb.findElement(By.name("company")).click();
        wb.findElement(By.name("company")).clear();
        wb.findElement(By.name("company")).sendKeys(contactDate.getCompany());
        wb.findElement(By.name("address")).click();
        wb.findElement(By.name("address")).clear();
        wb.findElement(By.name("address")).sendKeys(contactDate.getAddress());
        wb.findElement(By.name("home")).click();
        wb.findElement(By.name("home")).click();
        wb.findElement(By.name("home")).clear();
        wb.findElement(By.name("home")).sendKeys(contactDate.getHomePhone());
        wb.findElement(By.name("mobile")).click();
        wb.findElement(By.name("mobile")).clear();
        wb.findElement(By.name("mobile")).sendKeys(contactDate.getMobilePhone());
        wb.findElement(By.name("email")).click();
        wb.findElement(By.name("email")).clear();
        wb.findElement(By.name("email")).sendKeys(contactDate.getEmail());
    }

    protected void initCreationContact() {
        wb.findElement(By.linkText("add new")).click();
    }

    protected void returnToGroupPage() {
        wb.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        wb.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
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

    protected void initGroupCreation() {
        wb.findElement(By.name("new")).click();
    }

    protected void gotoGroupPage() {
        wb.findElement(By.linkText("groups")).click();
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

    protected void deleteSelectedGroups() {
        wb.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    }

    protected void selectGroup() {
        wb.findElement(By.name("selected[]")).click();
    }
}
