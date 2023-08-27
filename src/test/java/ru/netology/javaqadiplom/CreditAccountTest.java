package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    @Test
    public void yearChangeMoreCreditLimitBalanceTest() {
        CreditAccount account = new CreditAccount(
                1000,
                6_000,
                15);

        account.pay(8000);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
//---------------------------------------------------------------------------------------------------------------//

    @Test
    public void testPayBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                10);

        boolean expected = true;
        boolean actual = account.pay(15_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayOverCreditLimitBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                10);

        account.pay(10_000);

        int expected = 2000;

        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void testPayPositiveBalance() {
        CreditAccount account = new CreditAccount(
                5000,
                6_000,
                5);

        account.pay(2000);

        int expected = 3000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPayZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                5);

        boolean expected = true;
        boolean actual = account.pay(10_000);

        Assertions.assertEquals(expected, actual);
    }

    //---------------------------------------------------------------------------------------------------------------//
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15);

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void AddWithZeroBalanceTest() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                10);

        boolean expected = true;
        boolean actual = account.add(5_000);

        Assertions.assertEquals(expected, actual);
    }

    //----------------------------------------------------------------------------------------------------------------//
    @Test
    public void testIllegalArgumentExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -5000,
                    10000,
                    10);
        });
    }

    @Test
    public void testIllegalArgumentExceptionCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    5000,
                    -10000,
                    15);
        });
    }
}
