package org.fd.project.modules.user.service.core.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.dto.request.UserRequest;
import org.fd.project.modules.user.mapper.UserMapper;
import org.fd.project.modules.user.model.entity.User;
import org.fd.project.modules.user.service.adapter.command.UserCommandAdapter;
import org.fd.project.modules.user.service.adapter.query.UserQueryAdapter;
import org.fd.project.modules.user.service.core.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserQueryAdapter userQueryAdapter;
    private final UserCommandAdapter userCommandAdapter;

    private final UserMapper userMapper;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return userQueryAdapter.findAll(pageable);
    }

    @Override
    public User save(UserRequest request) {
        return userCommandAdapter.save(userMapper.mapToEntity(request));
    }

}
