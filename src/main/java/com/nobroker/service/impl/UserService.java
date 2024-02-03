package com.nobroker.service.impl;

import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public User registerUser(User user) {
        User save = userRepository.save(user);
        return save;
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }
        public boolean isEmailVerified(String email){
        User byEmail = userRepository.findByEmail(email);
        return byEmail!=null&& byEmail.isEmailVerified();
    }
}
