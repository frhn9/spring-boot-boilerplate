package org.fd.project.shared.dto.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSchema {

  @JsonProperty("response_code")
  private String responseCode;

  @JsonProperty("response_message")
  private String responseMessage;

}
