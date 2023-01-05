package org.fd.project.modules.user.service.adapter.query.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.model.entity.User;
import org.fd.project.modules.user.model.repository.UserRepository;
import org.fd.project.modules.user.service.adapter.query.UserQueryAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryAdapterImpl implements UserQueryAdapter {

    private final UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

}
