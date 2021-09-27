package ru.stqa.prf.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
      app.gotoPageGroup();
      app.initGroupCreation();
      app.fillGroupForm(new GroupData("test1", "test2", "test3"));
      app.SubmitGroupCreation();
      app.gotoPageGroup();
      app.returnGroupPage();
    }


}
