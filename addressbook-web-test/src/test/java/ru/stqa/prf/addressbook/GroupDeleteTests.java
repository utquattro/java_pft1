package ru.stqa.prf.addressbook;


import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {


    @Test
    public void testGroupDeletion() throws Exception {
        gotoPageGroup();
        selectedGroups();
        deleteSelectedGroups();
        returnGroupPage();

    }


}
