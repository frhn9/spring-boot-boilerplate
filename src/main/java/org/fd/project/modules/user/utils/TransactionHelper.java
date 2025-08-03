package org.fd.project.modules.user.utils;

import ch.qos.logback.core.util.StringUtil;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@UtilityClass
public class TransactionHelper {

    public static String createTransactionId(String externalId) {
        long epochMilli = ZonedDateTime.now().toInstant().toEpochMilli();
        return "ID" + epochMilli + StringUtil.capitalizeFirstLetter(externalId);
    }

    public static BigDecimal calculateRunningBalance(BigDecimal currentBalance, BigDecimal transactionAmount) {
        return currentBalance.subtract(transactionAmount);
    }

}
