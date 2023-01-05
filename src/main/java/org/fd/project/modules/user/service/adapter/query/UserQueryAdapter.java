package org.fd.project.modules.user.service.adapter.query;

import org.fd.project.modules.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserQueryAdapter {

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Integer id);

}
