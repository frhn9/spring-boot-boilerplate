package org.fd.project.modules.user.service.adapter.command;

import org.fd.project.modules.user.model.entity.User;

import java.util.List;

public interface UserCommandAdapter {
    User save(User user);
    List<User> saveAll(List<User> users);
}