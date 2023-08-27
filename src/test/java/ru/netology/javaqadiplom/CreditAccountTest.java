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
    public void IllegalArgumentExceptionInitialBalanceTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new CreditAccount(-1000, 10000, 15);});
    }
    @Test
    public void testIllegalArgumentExceptionCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new CreditAccount(5000, -10000, 15);});
    }
    @Test
    public void testPayBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(5_000, 10_000, 10);

        boolean expected = true;
        boolean actual = account.pay(15_000);

        Assertions.assertEquals(expected, actual);
    }
}
