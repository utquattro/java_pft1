package ru.stqa.prf.addressbook;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreateTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://192.168.31.179/addressbook/");
        login();
    }

    private void login() {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        gotoAddPage();
        fillUserForm(new UserData("Smith", "Ivan", "Kazan", "super@mail.ru", "89998887777", "31", "May", "1988", "2"));
        clickEnter();
        gotoContactPage();
        clickLogout();

    }

    private void clickLogout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void gotoContactPage() {
        wd.findElement(By.linkText("home")).click(); // open home
    }

    private void clickEnter() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillUserForm(UserData userData) {
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userData.getFirstname());
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userData.getLastname());
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(userData.getAddress());
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(userData.getMobile());
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(userData.getEmail());
        wd.findElement(By.xpath("//option[@value='" + userData.getDay() + "']")).click();
        wd.findElement(By.xpath("//option[@value='" + userData.getMonth() + "']")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(userData.getYear());
        wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[" + userData.getGroupnum() + "]")).click();

    }

    private void gotoAddPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}

