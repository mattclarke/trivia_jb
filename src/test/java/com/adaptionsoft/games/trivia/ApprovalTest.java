package com.adaptionsoft.games.trivia;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class ApprovalTest {
    @Test
    public void testJson()
    {
        Person hero = new Person("jayne", "cobb", true, 38);
        Approvals.verifyAsJson(hero);
    }
}
