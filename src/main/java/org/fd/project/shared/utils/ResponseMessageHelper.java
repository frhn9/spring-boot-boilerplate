package org.fd.project.shared.utils;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.fd.project.shared.constant.enums.ResponseEnum;
import org.fd.project.shared.dto.attribute.ResponseSchemaAttribute;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseMessageHelper {

  private final MessageSource responseMessageSource;

  public ResponseSchemaAttribute getResponseSchema(ResponseEnum responseEnum) {
    return ResponseSchemaAttribute.builder()
            .responseCode(responseEnum.getResponseCode())
            .responseMessage(getMessage(responseEnum.getResponseMessage()))
            .build();
  }

  private String getMessage(String code) {
    return responseMessageSource.getMessage(code, null, Locale.getDefault());
  }

}
