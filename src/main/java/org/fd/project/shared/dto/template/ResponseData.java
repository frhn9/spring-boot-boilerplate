package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.ResponseSchema;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {

  @JsonProperty("response_schema")
  private ResponseSchema responseSchema;

  @JsonProperty("data")
  private T data;

}