package ru.stqa.prf.addressbook.tests;


import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {


    @Test
    public void testGroupDeletion() throws Exception {
        app.gotoPageGroup();
        app.getGroupHelper().selectedGroups();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();

    }


}
