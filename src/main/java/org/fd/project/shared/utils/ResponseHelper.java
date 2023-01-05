package org.fd.project.shared.utils;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.fd.project.shared.constant.enums.ResponseEnum;
import org.fd.project.shared.dto.attribute.ErrorDetail;
import org.fd.project.shared.dto.attribute.PaginationConfig;
import org.fd.project.shared.dto.template.ResponseCollection;
import org.fd.project.shared.dto.template.ResponseData;
import org.fd.project.shared.dto.template.ResponseError;
import org.fd.project.shared.dto.template.ResponseList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseHelper {

  private final ResponseMessageHelper responseMessageHelper;

  /**
   * a utility function that is used to generate detailed responses
   * @param responseEnum Enum Response
   * @param <T> Generic Type, for class body return
   * @return ResponseEntity contain Template Response
   */
  public <T> ResponseEntity<ResponseData<T>> createResponseData(
          ResponseEnum responseEnum,
          T data
  ) {
    return ResponseEntity
            .status(responseEnum.getHttpStatus())
            .body(ResponseData.<T>builder()
                    .data(data)
                    .build());
  }

  public <T> ResponseEntity<ResponseList<T>> createResponseList(
          ResponseEnum responseEnum,
          List<T> list
  ) {
    return ResponseEntity
            .status(responseEnum.getHttpStatus())
            .body(ResponseList.<T>builder()
                    .responseSchema(responseMessageHelper.getResponseSchema(responseEnum))
                    .data(list)
                    .build());
  }

  public ResponseEntity<ResponseError> createResponseError(
      ResponseEnum responseEnum,
      List<ErrorDetail> errorDetails
  ) {
    return ResponseEntity
            .status(responseEnum.getHttpStatus())
            .body(ResponseError.builder()
                    .responseSchema(responseMessageHelper.getResponseSchema(responseEnum))
                    .errors(errorDetails)
                    .build());
  }

  public <T> ResponseEntity<ResponseCollection<T>> createResponseCollection(
          ResponseEnum responseEnum,
          Page<T> page
  ) {
    return ResponseEntity
            .status(responseEnum.getHttpStatus())
            .body(ResponseCollection.<T>builder()
                    .responseSchema(responseMessageHelper.getResponseSchema(responseEnum))
                    .pagination(new PaginationConfig(page.getNumber(), page.getSize(), page.getTotalElements()))
                    .data(page.getContent())
                    .build());
  }

}
