package org.fd.project.shared.dto.template;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.PaginationConfig;
import org.fd.project.shared.dto.attribute.ResponseSchema;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCollection<T> {

	@JsonProperty("response_schema")
	private ResponseSchema responseSchema;

	@JsonProperty("pagination")
	private PaginationConfig pagination;

	@JsonProperty("data")
	private List<T> data;

}