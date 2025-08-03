package org.fd.project.modules.user.exception;

import org.fd.project.config.exception.ModuleException;
import org.fd.project.shared.constant.enums.ResponseEnum;

public class UserBlockedByBankException extends ModuleException {

    public UserBlockedByBankException() {
        super(ResponseEnum.USER_BLOCKED_BY_BANK);
    }
}
