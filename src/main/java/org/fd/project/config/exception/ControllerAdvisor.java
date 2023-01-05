package org.fd.project.config.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fd.project.shared.constant.enums.ResponseEnum;
import org.fd.project.shared.dto.attribute.ErrorDetail;
import org.fd.project.shared.dto.template.ResponseError;
import org.fd.project.shared.utils.ResponseHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  private final ResponseHelper responseHelper;

  @ExceptionHandler(ModuleException.class)
  public ResponseEntity<ResponseError> handleException(ModuleException exception) {
    return responseHelper.createResponseError(exception.getResponseEnum(), null);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseError> handleException(
          Exception ex,
          HttpServletRequest request,
          HttpServletResponse response
  ) {
    Arrays.stream(ex.getStackTrace()).limit(5).forEach(logger::error);
    logger.error(ex.getMessage());
    return responseHelper.createResponseError(ResponseEnum.INTERNAL_SERVER_ERROR, null);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
          MethodArgumentNotValidException ex,
          HttpHeaders headers,
          org.springframework.http.HttpStatusCode status,
          WebRequest request
  ) {
    List<ErrorDetail> errors = new ArrayList<>();
    ex.getFieldErrors().forEach(fieldError ->
            errors.add(new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()))
    );

    return ResponseEntity.badRequest()
            .body(responseHelper.createResponseError(ResponseEnum.INVALID_PARAM, errors));
  }

}
