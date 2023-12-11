package org.example.service;

import org.example.model.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean createUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        userRepo.save(user);

        return true;
    }

    @Override
    public User findUserByEmail(String username) throws UsernameNotFoundException {

        return userRepo.findByUsername(username);
    }
}
