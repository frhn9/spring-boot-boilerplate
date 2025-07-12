package org.fd.project.modules.user.mapper;

import org.fd.project.modules.user.dto.request.UserRequest;
import org.fd.project.modules.user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToEntity(UserRequest request);

}
