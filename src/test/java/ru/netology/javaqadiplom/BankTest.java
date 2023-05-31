package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void Test1() { // платеж слишком высокий, конечная сумма меньше мин
        SavingAccount account1 = new SavingAccount(10_000, 1_000, 10_000, 5);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 20_000, 5);
        Bank.transfer(account1, account2, 9000);
        Assertions.assertEquals(10_000, account2.getBalance());
    }

    @Test
    public void Test2() { // платеж слишком высокий, конечная сумма меньше мин
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        CreditAccount account2 = new CreditAccount(0, 5_000, 15);
        Bank.transfer(account1, account2, 4000);
        Assertions.assertEquals(4_000, account2.getBalance());

    }

    @Test
    public void Test3() { // платеж слишком высокий, конечная сумма меньше мин
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        CreditAccount account2 = new CreditAccount(0, 5_000, 15);
        Assertions.assertEquals(false, Bank.transfer(account1, account2, 0));

    }
}
