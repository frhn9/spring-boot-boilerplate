package org.fd.project.modules.user.service.core;

import org.fd.project.modules.user.dto.request.UserRequest;
import org.fd.project.modules.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getPage(Pageable pageable);

    User save(UserRequest request);

}
