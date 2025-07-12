package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import lombok.*;
import org.fd.project.shared.dto.attribute.ErrorAttribute;
import org.fd.project.shared.dto.attribute.ResponseSchemaAttribute;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

  @JsonProperty("responseSchema")
  private ResponseSchemaAttribute responseSchema;

  @JsonProperty("errors")
  private List<ErrorAttribute> errors;

}
