package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import lombok.*;
import org.fd.project.shared.dto.attribute.ErrorDetail;
import org.fd.project.shared.dto.attribute.ResponseSchema;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

  @JsonProperty("response_schema")
  private ResponseSchema responseSchema;

  @JsonProperty("errors")
  private List<ErrorDetail> errors;

}
