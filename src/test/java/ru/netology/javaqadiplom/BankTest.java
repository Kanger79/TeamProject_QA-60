package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class BankTest {
    Bank bank = new Bank();

    @Test
    public void usuallyTransfer() { // обычный перевод в рамках балансов
        SavingAccount account1 = new SavingAccount(5000, 1000, 10_000, 10);
        SavingAccount account2 = new SavingAccount(5000, 1000, 10_000, 10);

        System.out.print("Балланос  первого  до  перевода = " + account1.getBalance());
        System.out.println(" Балланос  второго  до  перевода = " + account2.getBalance());
        Assertions.assertEquals(true, bank.transfer(account1, account2, 2000));
        //  System.out.println("Первый переводит второму " + CreditAccount(amount) +)
        System.out.print("Балланос первого после перевода = " + account1.getBalance());
        System.out.println(" Балланос второго после перевода = " + account2.getBalance());
    }

    @Test
    public void firstLessSecondTransfer() {
        SavingAccount account1 = new SavingAccount(5000, 1000, 10_000, 10);
        SavingAccount account2 = new SavingAccount(5000, 1000, 10_000, 10);

        System.out.print("Балланос  первого  до  перевода = " + account1.getBalance());
        System.out.println(" Балланос  второго  до  перевода = " + account2.getBalance());
        Assertions.assertEquals(false, bank.transfer(account1, account2, 5000));
        //  System.out.println("Первый переводит второму " + CreditAccount(amount) +)
        System.out.print("Балланос первого после перевода = " + account1.getBalance());
        System.out.println(" Балланос второго после перевода = " + account2.getBalance());
    }

    @Test
    public void transferBetweenCreditsFailedDueToLimit() {//перевод между кредитными не выполнился из-за ограничения лимита

        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 3_000, 15);
        CreditAccount account2 = new CreditAccount(1_000, 5_000, 15);

        System.out.print("Балланос  первого  до  перевода = " + account1.getBalance());
        System.out.println(" Балланос  второго  до  перевода = " + account2.getBalance());

        Assertions.assertEquals(false, bank.transfer(account1, account2, 4000));

        System.out.print("Балланос первого после перевода = " + account1.getBalance());
        System.out.println(" Балланос второго после перевода = " + account2.getBalance());
    }

    @Test
    public void transferWithNegativePay() {//перевод между кредитными не выполнился из-за ограничения лимита

        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        CreditAccount account2 = new CreditAccount(5_000, 5_000, 15);

        System.out.print("Балланос  первого  до  перевода = " + account1.getBalance());
        System.out.println(" Балланос  второго  до  перевода = " + account2.getBalance());

        Assertions.assertEquals(false, bank.transfer(account1, account2, -1000));

        System.out.print("Балланос первого после перевода = " + account1.getBalance());
        System.out.println(" Балланос второго после перевода = " + account2.getBalance());
    }

    @Test
    public void transferBetweenCreditAndSavingAccountMaxBalance() {
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 9_000, 5);

        System.out.print("Балланос  первого  до  перевода = " + account1.getBalance());
        System.out.println(" Балланос  второго  до  перевода = " + account2.getBalance());

        Assertions.assertEquals(false, bank.transfer(account1, account2, 5000));

        System.out.print("Балланос первого после перевода = " + account1.getBalance());
        System.out.println(" Балланос второго после перевода = " + account2.getBalance());


    }

}
