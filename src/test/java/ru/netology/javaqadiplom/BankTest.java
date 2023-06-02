package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void transferBetweenSavingsAccounts() { //перевод между накопителными счетами
        Bank bank = new Bank();
        SavingAccount account1 = new SavingAccount(5_000, 1_000, 10_000, 5);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 4000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());

    }

    @Test
    public void transferBetweenSavingsAccountsFailedDueToFirstAccount() {//перевод между накопителными счетами не выполнился из-за первого счета
        Bank bank = new Bank();
        SavingAccount account1 = new SavingAccount(5_000, 1_000, 10_000, 5);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 5000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());

    }

    @Test
    public void transferBetweenSavingsAccountsFailedDueToSecondAccount() {//перевод между накопителными счетами не выполнился из-за второго счета
        Bank bank = new Bank();
        SavingAccount account1 = new SavingAccount(5_000, 1_000, 10_000, 5);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 7_000, 5);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 2000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());

    }

    @Test
    public void zeroTransferBetweenSavingsAccountsFailed() {//нулевой перевод между накопителными счетами не выполнился
        Bank bank = new Bank();
        SavingAccount account1 = new SavingAccount(5_000, 1_000, 10_000, 5);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 0));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());

    }

    @Test
    public void transferBetweenCreditAccounts() {//перевод между кредитными счетами
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(5_000, 5_000, 15);
        CreditAccount account2 = new CreditAccount(1_000, 5_000, 15);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());

    }

    @Test
    public void transferBetweenCreditsFailedDueToLimitLimit() {//перевод между кредитными не выполнился из-за ограничения лимита
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 4_000, 15);
        CreditAccount account2 = new CreditAccount(1_000, 5_000, 15);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenLoanAccounts() {//перевод между кредитными счетами кредита
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        CreditAccount account2 = new CreditAccount(1_000, 5_000, 15);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void zeroTransferBetweenCreditAccountsFailed() {//нулевой перевод между кредитными счетами не выполнился
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(3_000, 5_000, 15);
        CreditAccount account2 = new CreditAccount(1_000, 5_000, 15);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 0));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenCreditAndSavingsAccount() {//перевод между кредитными и накопительным счетом
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(6_000, 5_000, 15);
        SavingAccount account2 = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenASavingsAccountAndALoanAccount() {//перевод между накопительным и кредитным счетом
        Bank bank = new Bank();
        CreditAccount account2 = new CreditAccount(3_000, 5_000, 15);
        SavingAccount account1 = new SavingAccount(6_000, 1_000, 10_000, 5);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenASavingsAccountAndALoanAccountOnCredit() {//перевод между кредитными и накопительным счетом в кредит
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(true, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenCreditAndSavingsAccountsOnCreditLimitExceeded() {//перевод между кредитными и накопительным счетом в кредит превышен лимит
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 6_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenCreditAndSavingsAccountMaximumBalanceExceeded() {//перевод между кредитными и накопительным счетом превышен максимальный баланс
        Bank bank = new Bank();
        CreditAccount account1 = new CreditAccount(0, 5_000, 15);
        SavingAccount account2 = new SavingAccount(5_000, 1_000, 9_000, 5);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }

    @Test
    public void transferBetweenSavingsAndLoanAccountBalanceTooLow() {//перевод между накопительным и кредитным счетом слишком низкий баланс
        Bank bank = new Bank();
        CreditAccount account2 = new CreditAccount(3_000, 5_000, 15);
        SavingAccount account1 = new SavingAccount(5_000, 1_000, 10_000, 5);
        Assertions.assertEquals(false, bank.transfer(account1, account2, 5_000));
        System.out.println("Баланс счета с которого переводим:" + account1.getBalance());
        System.out.println("Баланс счета на который переводим:" + account2.getBalance());
    }
}
