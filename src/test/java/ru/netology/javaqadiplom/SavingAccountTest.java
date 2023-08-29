package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SavingAccountTest {

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
