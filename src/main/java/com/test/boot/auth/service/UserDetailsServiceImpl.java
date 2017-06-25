package com.test.boot.auth.service;

import com.test.boot.Model.UsersEntity;
import com.test.boot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("------------------->" + username);
        UsersEntity user = userRepository.findByUsername(username);
        System.out.println("-------------------><<" + user.getUsername() + " , " + user.getPassword());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRoleByIdRole().getRoleNames()));
        System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRoleByIdRole().getRoleNames());
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
