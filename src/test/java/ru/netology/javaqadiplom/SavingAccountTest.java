package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddToPositiveBalanceNegativeAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test
    public void testNegativePaymentAmount() { // проверка на негативное (меньше нуля) значение amount
        int initialBalance = 10_000;
        int creditLimit = 15_000;
        int amount = -1000;

        ru.netology.javaqadiplom.CreditAccount account = new ru.netology.javaqadiplom.CreditAccount(initialBalance, creditLimit, 10);
        boolean result = account.pay(amount);
        assertFalse(result);
        assertEquals(10000, account.getBalance());
    }
}

