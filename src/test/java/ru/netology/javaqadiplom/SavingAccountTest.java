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
    @Test
    public void testPayPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                10
        );

        account.add(10_000);

        int expected = 2_000;

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void shouldNotPayBeyondBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(3_000);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(4_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(5_000 - 4_000, account.getBalance());
    }

    @Test
    public void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void testIllegalArgumentExceptionMinBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(5_000, 2_000, 1_000, 5));
    }

    @Test
    public void testIllegalArgumentExceptionInitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500, 1_000, 10_000, 5));
    }

    @Test
    public void testIllegalArgumentExceptionInitialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(15_000, 1_000, 10_000, 5));
    }
}
