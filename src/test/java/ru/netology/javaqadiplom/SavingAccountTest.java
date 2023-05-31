package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void negativeMeaningRate() { //отрицательный процент
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 1_000, 10_000, -5);
        });
    }

    @Test
    public void minGreaterMax() { //мин больше макс
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 10_000, 5_000, 5);
        });
    }

    @Test
    public void bigMax() { // баланс больше макс
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new SavingAccount(15_000, 1_000, 10_000, 5);
        });
    }

    @Test
    public void lessMin() { // баланс меньше мин
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new SavingAccount(1_000, 2_000, 10_000, 5);
        });
    }

    @Test
    public void minNegative() { // отрицательный мин
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new SavingAccount(3_000, -2_000, 5_000, 5);
        });
    }

    @Test
    public void paymentWasSuccessful() { // обычный платеж
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(5_000 - 3_000, account.getBalance());
    }

    @Test
    public void paymentFailedInsufficientFunds() { // платеж слишком высокий, конечная сумма меньше мин
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(100_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void paymentFailedBalanceCannotBeLessThanMin() { // конечная сумма меньше мин
        SavingAccount account = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );

        account.pay(4_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void negativePayment() { //сумма платежа отрицательная
        SavingAccount account = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );

        account.pay(-4_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void paymentPassedAmountEqualToMin() { // результат оплаты равен мин
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(4_000);

        Assertions.assertEquals(5_000 - 4_000, account.getBalance());
    }

    @Test
    public void toppedUpByMaxAmount() { // результат пополнения равен макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void replenishmentSuccessfully() { // обычное пополнение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                6_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(3_000 + 2_000, account.getBalance());

    }

    @Test
    public void replenishmentWithANegativeAmount() { // отрицательное пополнение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5
        );

        account.add(-2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void refillMoreMax() { // результат пополнения больше макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5
        );

        account.add(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void interestOnTheBalance() { // считаем процент на остаток
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(750, account.yearChange());
    }
}
