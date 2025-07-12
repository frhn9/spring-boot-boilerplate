package org.fd.project.shared.dto.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSchemaAttribute {

  @JsonProperty("responseCode")
  private String responseCode;

  @JsonProperty("responseMessage")
  private String responseMessage;

}
