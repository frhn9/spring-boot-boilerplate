package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.ResponseSchema;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseList<T> {

  @JsonProperty("response_schema")
  private ResponseSchema responseSchema;

  @JsonProperty("data")
  private List<T> data;

}