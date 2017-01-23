package com.blog;

import com.blog.User;
import com.blog.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Danny Madeley on 23/01/17.
 */
@Service
public class UserService {
    @Autowired
    protected UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User validateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);

    }


}

