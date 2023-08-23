package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void testYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -4_000,
                5_000,
                10);


        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayOverCreditLimitBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                10
        );

        account.pay(10_000);

        int expected = 2000;

        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -2_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(1_000, account.getBalance());
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
    public void testIllegalArgumentExceptionInitialBalance() {
        int initialBalance = -5_000;
        int creditLimit = 10_000;
        int amount = 0;

        ru.netology.javaqadiplom.CreditAccount account = new ru.netology.javaqadiplom.CreditAccount(initialBalance, creditLimit, 10);
        boolean result = account.pay(amount);
        assertFalse(result);
            }
}
