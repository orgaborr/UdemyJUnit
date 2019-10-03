package com.ogabor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {

    private BankAccount account;
//    private double amount;
//    private boolean branch;
//    private double expected;

//    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
//        this.amount = amount;
//        this.branch = branch;
//        this.expected = expected;
//    }

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        account = new BankAccount("Gábor", "Orbán", 1000.00, BankAccount.CHECKING);
        System.out.println("Running test...");
    }

    private static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.0, true, 2000.0}
        });
    }

//    private static Stream<Arguments> streamConditions() {
//        return Stream.of(
//                Arguments.of(100.00, true, 1100.00),
//                Arguments.of(200.00, true, 1200.00),
//                Arguments.of(325.14, true, 1325.14),
//                Arguments.of(489.33, true, 1489.33),
//                Arguments.of(1000.00, true, 2000.00)
//        );
//    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
