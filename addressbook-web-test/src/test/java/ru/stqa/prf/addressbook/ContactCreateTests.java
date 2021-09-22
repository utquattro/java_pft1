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
        fillNameForm("Bukin","Ivan","bro","xxxNaGubatoRxxx");
        fillWorkForm("Google", "Kazan");
        fillTelForm("2444888", "89998887656");
        fillMailSiteForm("super@mail.ru");
        fillBdayForm("31","May","1988");
        fillGroupForm("2");
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

    private void fillGroupForm(final String groupnum) {
        wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[" + groupnum + "]")).click();
    }

    private void fillBdayForm(final String day, final String month, String year) {
        wd.findElement(By.xpath("//option[@value='" + day + "']")).click();
        wd.findElement(By.xpath("//option[@value='" + month + "']")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(year);
    }

    private void fillMailSiteForm(String email) {
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(email);
    }

    private void fillTelForm(String numhome, String nummobile) {
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(numhome);
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(nummobile);
    }

    private void fillWorkForm(String company, String address) {
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(company);
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address);
    }

    private void fillNameForm(String lastname, String firstname, String middlename, String nickname) {
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstname);
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middlename);
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastname);
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickname);
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

