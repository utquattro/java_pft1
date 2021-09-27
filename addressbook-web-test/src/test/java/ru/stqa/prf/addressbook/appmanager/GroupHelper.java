package ru.stqa.prf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.prf.addressbook.models.GroupData;

public class GroupHelper {
     private WebDriver wd;

    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void returnGroupPage() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void SubmitGroupCreation() {
      wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectedGroups() {
        wd.findElement(By.name("selected[]")).click();
    }
}
