package ru.stqa.prf.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    protected void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://192.168.31.179/addressbook/");
        login("admin", "secret");
    }

    private void login(String login, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void returnGroupPage() {
      wd.findElement(By.linkText("Logout")).click();
    }

    protected void SubmitGroupCreation() {
      wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void gotoPageGroup() {
      wd.findElement(By.linkText("groups")).click();
    }

    protected void initGroupCreation() {
      wd.findElement(By.name("new")).click();
    }

    protected void stop() {
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

    protected void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectedGroups() {
        wd.findElement(By.name("selected[]")).click();
    }
}
