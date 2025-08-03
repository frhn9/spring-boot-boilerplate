package org.fd.project.modules.user.exception;

import org.fd.project.config.exception.ModuleException;
import org.fd.project.shared.constant.enums.ResponseEnum;

public class PaymentTypeNotFoundException extends ModuleException {
    public PaymentTypeNotFoundException() {
        super(ResponseEnum.PAYMENT_TYPE_NOT_FOUND);
    }
}
