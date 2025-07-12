package org.fd.project.modules.user.service.adapter.command.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.model.entity.User;
import org.fd.project.modules.user.model.repository.UserRepository;
import org.fd.project.modules.user.service.adapter.command.UserCommandAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCommandAdapterImpl implements UserCommandAdapter {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

}
