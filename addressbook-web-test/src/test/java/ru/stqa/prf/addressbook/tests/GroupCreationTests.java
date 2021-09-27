package ru.stqa.prf.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.prf.addressbook.models.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoPageGroup();
      app.getGroupHelper().initGroupCreation();
      app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
      app.getGroupHelper().SubmitGroupCreation();
      app.getNavigationHelper().gotoPageGroup();
      app.getGroupHelper().returnGroupPage();
    }


}
