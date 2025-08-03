package org.fd.project.modules.user.utils;

import lombok.experimental.UtilityClass;
import org.fd.project.modules.user.exception.BalanceInsufficientException;
import org.fd.project.modules.user.exception.UserBlockedByBankException;

import java.math.BigDecimal;

@UtilityClass
public class TransactionValidationHelper {

    public static void validateBlockedUser(boolean isBlockedByBank) {
        if (isBlockedByBank) {
            throw new UserBlockedByBankException();
        }
    }

    public static void validateBalance(BigDecimal accountBalanceDerived, BigDecimal transactionAmount) {
        if (accountBalanceDerived.compareTo(transactionAmount) < 0) {
            throw new BalanceInsufficientException();
        }
    }

}
