package ru.addressbook;

import org.junit.jupiter.api.Test;

public class CreateGroup extends TestBase{


    @Test
    public void testCreateGroup() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Test2", "Test2", "Test2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
