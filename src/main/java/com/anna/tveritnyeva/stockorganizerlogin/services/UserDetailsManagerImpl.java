package com.anna.tveritnyeva.stockorganizerlogin.services;

import com.anna.tveritnyeva.stockorganizerlogin.beans.Role;
import com.anna.tveritnyeva.stockorganizerlogin.beans.User;
import com.anna.tveritnyeva.stockorganizerlogin.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsManagerImpl implements UserDetailsManager {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            List<String> roleList = new ArrayList<>();
            for (Role role : user.getRoles()) {
                roleList.add(role.getRoleName());
            }

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    //change here to store encoded password in db
                    .password(passwordEncoder.encode(user.getPassword()))
                    .disabled(user.isDisabled())
                    .accountExpired(user.isAccountExpired())
                    .accountLocked(user.isAccountLocked())
                    .credentialsExpired(user.isCredentialsExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("Wrong user name");
        }
    }

    @Override
    public void createUser(UserDetails user) {
        //TODO: override
    }

    @Override
    public void updateUser(UserDetails user) {
        //TODO: override
    }

    @Override
    public void deleteUser(String username) {
        //TODO: override
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        //TODO: override (remember to encode)
    }

    @Override
    public boolean userExists(String username) {
        //TODO: override
        return false;
    }
}
