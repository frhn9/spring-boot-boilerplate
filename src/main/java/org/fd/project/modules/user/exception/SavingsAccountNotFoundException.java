package org.fd.project.modules.user.exception;

import org.fd.project.config.exception.ModuleException;
import org.fd.project.shared.constant.enums.ResponseEnum;

public class SavingsAccountNotFoundException extends ModuleException {
    public SavingsAccountNotFoundException() {
        super(ResponseEnum.SAVINGS_ACCOUNT_NOT_FOUND);
    }
}
