package ru.stqa.prf.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
      gotoPageGroup();
      initGroupCreation();
      fillGroupForm(new GroupData("test1", "test2", "test3"));
      SubmitGroupCreation();
      gotoPageGroup();
      returnGroupPage();
    }


}
