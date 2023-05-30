package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToNullBalance() { // пополнение при нулевом балансе
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        System.out.print("Тест-1_Пополнение при нулевом балансе. До пополниения на балансе " + account.getBalance());

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
        System.out.println("р, после пополнения " + account.balance + "р.");
    }

    @Test
    public void shouldAddToPositiveBalance() { // пополнение при положительном балансе
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        System.out.print("Тест-2_Пополнение при положительном балансе. До пополниения на балансе " + account.getBalance());

        account.add(4_000);

        Assertions.assertEquals(5_000, account.getBalance());
        System.out.println("р, после пополнения " + account.balance + "р.");
    }

    @Test
    public void shouldAddToNegativeBalance() { // пополнение при отрицательном балансе
        CreditAccount account = new CreditAccount(
                -1000,
                5_000,
                15
        );
        System.out.print("Тест-3_Пополнение при отрицательном балансе. До пополниения на балансе " + account.getBalance());

        account.add(5_000);

        Assertions.assertEquals(4_000, account.getBalance());
        System.out.println("р, после пополнения " + account.balance + "р.");
    }

    @Test
    public void payPositiveBalanceLessCreditLimit() { //покупка при положительном балансе в пределах кредитного лимита
        CreditAccount account = new CreditAccount(
                4_000,
                3_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(3000, account.getBalance());

    }

    @Test
    public void payPositiveBalanceMoreCreditLimit() { //покупка при положительном балансе в пределах кредитного лимита
        CreditAccount account = new CreditAccount(
                4_000,
                3_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(3000, account.getBalance());

    }

    @Test
    public void yearChangeNegativeBalance() { // Расчет процентов на отрицательный баланс
        CreditAccount account = new CreditAccount(
                -200,
                3000,
                15
        );
        System.out.print("Тест-5_Расчет процентов на отрицательный баланс. При балансе " + account.getBalance() + "р, и процентной ставке " + account.getRate() + "%, ");
        account.yearChange();

        Assertions.assertEquals(-30, account.yearChange());
        System.out.println("оплата процентов составит " + account.yearChange());

    }

    @Test
    public void yearChangePositiveBalance() { // Расчет процентов на отрицательный баланс при положительном балансе
        CreditAccount account = new CreditAccount(
                200,
                3000,
                15
        );
        System.out.print("Тест-6_Расчет процентов на отрицательный баланс при положительном балансе. При балансе " + account.getBalance() + "р, и процентной ставке " + account.getRate() + "%, ");
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
        System.out.println("оплата процентов составит " + account.yearChange());
    }

    @Test
    public void testNegativeRate() {

        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -200,
                    3000,
                    -15
            );
        });
        System.out.println("Тест-7_");
    }

}
