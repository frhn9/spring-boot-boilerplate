package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.ResponseSchemaAttribute;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {

  @JsonProperty("responseSchema")
  private ResponseSchemaAttribute responseSchema;

  @JsonProperty("data")
  private T data;

}