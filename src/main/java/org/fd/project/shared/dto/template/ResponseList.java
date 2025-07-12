package org.fd.project.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.ResponseSchemaAttribute;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseList<T> {

  @JsonProperty("responseSchema")
  private ResponseSchemaAttribute responseSchemaAttribute;

  @JsonProperty("data")
  private List<T> data;

}