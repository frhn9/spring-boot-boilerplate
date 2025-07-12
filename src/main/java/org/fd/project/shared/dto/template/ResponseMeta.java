package org.fd.project.shared.dto.template;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.fd.project.shared.dto.attribute.MetaAttribute;
import org.fd.project.shared.dto.attribute.ResponseSchemaAttribute;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMeta<T> {

	@JsonProperty("responseSchema")
	private ResponseSchemaAttribute responseSchema;

	@JsonProperty("meta")
	private MetaAttribute meta;

	@JsonProperty("data")
	private List<T> data;

}