package org.fd.project.modules.user.exception;

import org.fd.project.config.exception.ModuleException;
import org.fd.project.shared.constant.enums.ResponseEnum;

public class BalanceInsufficientException extends ModuleException {

    public BalanceInsufficientException() {
        super(ResponseEnum.BALANCE_INSUFFICIENT);
    }
}
