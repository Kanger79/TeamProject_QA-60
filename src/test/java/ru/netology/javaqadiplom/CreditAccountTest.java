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
        System.out.println("р, после пополнения на 3000р стало " + account.balance + "р.");

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
        System.out.println("р, после пополнения на 4000р стало " + account.balance + "р.");
    }

    @Test
    public void shouldAddToNegativeBalance() { // пополнение при отрицательном балансе
        CreditAccount account = new CreditAccount(
                0,
                4_000,
                15
        );
        System.out.print("Тест-3_Пополнение при отрицательном балансе. До пополниения на балансе " + account.getBalance());
        account.pay(2_000);
        account.add(5_000);

        Assertions.assertEquals(3_000, account.getBalance());
        System.out.println("р, покупаем в кредит (-2000р) и пополняем на 5000р, получаем " + account.balance + "р.");
    }

    @Test
    public void payPositiveBalanceLessCreditLimit() { //покупка при положительном балансе в пределах кредитного лимита
        CreditAccount account = new CreditAccount(
                4_000,
                3_000,
                15
        );
        System.out.print("Тест-4_Покупка при положительном балансе. До покупки на балансе " + account.getBalance());
        account.pay(1_000);

        Assertions.assertEquals(3000, account.getBalance());
        System.out.println("р, покупаем на 1000р, остается " + account.getBalance());

    }

    @Test
    public void payPositiveBalanceMoreCreditLimit() { //покупка при положительном балансе превышающая кредитный лимит
        CreditAccount account = new CreditAccount(
                1_000,
                2_000,
                15
        );

        account.pay(4_000);

        Assertions.assertEquals(1_000, account.getBalance());
        System.out.println("Тест-5_На балансе " + account.getBalance() + "р, стоимость покупки (4000р) превышает кредитный лимит " + account.getCreditLimit() + "р, покупка не состоялась, на балансе " + account.getBalance());
    }

    @Test
    public void yearChangeNegativeBalance() { // Расчет процентов на отрицательный баланс
        CreditAccount account = new CreditAccount(
                1000,
                3000,
                15
        );
        account.pay(3000);

        System.out.print("Тест-6_Расчет процентов на отрицательный баланс. При балансе " + account.getBalance() + "р, и процентной ставке " + account.getRate() + "%, ");
        account.yearChange();

        Assertions.assertEquals(-300, account.yearChange());
        System.out.println("оплата процентов составит " + account.yearChange());

    }

    @Test
    public void yearChangePositiveBalance() { // Расчет процентов на отрицательный баланс при положительном балансе
        CreditAccount account = new CreditAccount(
                1000,
                3000,
                15
        );
        account.pay(500);

//        account.pay(500);

        System.out.print("Тест-7_Расчет процентов на отрицательный баланс при положительном балансе. При балансе " + account.getBalance() + "р, и процентной ставке " + account.getRate() + "%, ");
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
        System.out.println("оплата процентов составит " + account.yearChange());
    }

    @Test
    public void testNegativeRate() {

        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CreditAccount(
                    4000,
                    3000,
                    -15
            );
        });
        System.out.println("Тест-8_Проверка наличия исключения в случае отрицательной кредитной ставке");
    }

    @Test
    public void negativeInitialBalance() {

        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -4000,
                    3000,
                    15
            );
        });

        System.out.println("Тест-9_Проверка наличия исключения в случае, когда начальный баланс отрицательный");

    }

    @Test
    public void negativeLimitCheckCreditLimit() {

        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CreditAccount(
                    4000,
                    -3000,
                    15
            );
        });

        System.out.println("Тест-10_Кредитный лимит не может принимать отрицательное значение");

    }

    @Test
    public void negativeAmountInPay() {
        CreditAccount account = new CreditAccount(
                2000,
                4000,
                15
        );
        account.pay(-50);
        Assertions.assertEquals(0, account.yearChange());
        System.out.println("Тест-11_Оплата не может быть отрицательной, покупка не состоялась");
    }

    @Test
    public void negativeAmountInAdd() {  //отрицательное пополнение
        CreditAccount account = new CreditAccount(
                2000,
                4000,
                15
        );
        account.add(-50);
        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(0, account.yearChange());
        System.out.println("Тест-13_Пополнение не может быть отрицательным.");
    }

//    @Test
//    public void yearChangeNegativeBalanceLittleSum() { // Расчет процентов на отрицательный баланс с суммой эквивалентной процентной ставке
//        CreditAccount account = new CreditAccount(
//                500,
//                3000,
//                80
//        );
//        account.pay(599);
//
//
//        account.yearChange();
//
//        Assertions.assertEquals(-79, account.yearChange());
//
//
//    }


}
