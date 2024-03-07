package com.esun.library.service;

import com.esun.library.repository.UserRepository;
import com.esun.library.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean register(User user) {
        if (user.getPhone() == null || user.getPassword() == null) return false;
        if (user.getPhone().isBlank()) return false;
        if (user.getPassword().length() < 8) return false;

        // check if the phone number is already registered
        User targetUser = userRepository.findByPhone(user.getPhone());
        if (targetUser != null) return false;

        // create a new user
        String formatName = user.getName().trim();
        if (formatName.isBlank()) user.setName("User" + UUID.randomUUID());    // generate a name
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(User user) {
        // find the user by phone number
        User targetUser = userRepository.findByPhone(user.getPhone());
        if (targetUser == null) return false;

        // check if the password matches
        if (!targetUser.getPassword().equals(user.getPassword())) return false;

        // TODO: Verify the phone number
        boolean isVerified = false;

        return true;
    }
}
