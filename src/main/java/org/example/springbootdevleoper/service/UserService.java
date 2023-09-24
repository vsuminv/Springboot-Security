package org.example.springbootdevleoper.service;


import lombok.RequiredArgsConstructor;
import org.example.springbootdevleoper.domain.AdduserRequest;
import org.example.springbootdevleoper.domain.User;
import org.example.springbootdevleoper.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService  {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public void save(AdduserRequest userDTO)  {
        User user = User.builder()
                .user_id(userDTO.getUser_id())
                .email(userDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .passwordCheck(userDTO.getPasswordCheck())
                .name(userDTO.getName())
                .birthY(userDTO.getBirthY())
                .birthM(userDTO.getBirthM())
                .birthD(userDTO.getBirthD())
                .register_date(userDTO.getRegister_date())
                .build();

        userRepository.save(user);

    }






}
