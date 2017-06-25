package com.test.boot.auth.service;


import com.test.boot.Model.UsersEntity;
import com.test.boot.Repository.RoleRepository;
import com.test.boot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UsersEntity user) {
        user.setPassword(user.getPassword());
        user.setRoleByIdRole(roleRepository.findOne(1l));
        user.setEmail(user.getUsername() + "@gmail.com");
        userRepository.save(user);
    }

    @Override
    public UsersEntity findByName(String name) {
        return userRepository.findByUsername(name);
    }
}
