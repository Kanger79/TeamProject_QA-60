package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );


        Assertions.assertEquals(30, account.yearChange());
    }
}
