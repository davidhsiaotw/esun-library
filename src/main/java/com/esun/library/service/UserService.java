package com.esun.library.service;

import com.esun.library.repository.entity.User;

public interface UserService {
    boolean register(User user);

    boolean login(User user);
}
