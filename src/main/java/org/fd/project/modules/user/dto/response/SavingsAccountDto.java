package org.fd.project.modules.user.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SavingsAccountDto {
    private String accountNumber;
    private String accountName;
    private String externalId;
    private BigDecimal accountBalanceDerived;
}
