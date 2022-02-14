package ru.addressbook;

import org.junit.jupiter.api.Test;

public class DeleteGroup extends TestBase {

    @Test
    public void testDeleteGroups()  {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }

}
