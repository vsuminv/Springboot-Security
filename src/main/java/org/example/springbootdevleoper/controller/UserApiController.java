package org.example.springbootdevleoper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdevleoper.domain.AdduserRequest;
import org.example.springbootdevleoper.domain.ResponseDTO;
import org.example.springbootdevleoper.domain.User;
import org.example.springbootdevleoper.repository.UserRepository;
import org.example.springbootdevleoper.service.UserDetailService;
import org.example.springbootdevleoper.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/test" )
public class UserApiController {

    private final UserService userService;
    private final UserDetailService detailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/user")
    public ResponseEntity signup(@RequestBody  AdduserRequest request){
        userService.save(request);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/login")
    public ResponseEntity loadUserByUsername(@RequestBody AdduserRequest adduserRequest, String email) {
//        detailService.loadUserByUsername(email);
//        return ResponseEntity.ok().body(adduserRequest);
//        detailService.loadUserByUsername(email);
//        return ResponseEntity.ok().body(email);


        User user = detailService.loadUserByUsername(
                adduserRequest.getEmail());

        if (!bCryptPasswordEncoder.matches(adduserRequest.getPassword(), user.getPassword() )) {
                throw new BadCredentialsException("잘못된 계정정보입니다.");

        }else{
            adduserRequest.setPassword(bCryptPasswordEncoder.encode(adduserRequest.getPassword()));
            ResponseDTO responseDTO = ResponseDTO.builder().result(1).build();
            return ResponseEntity.ok().body(responseDTO);
        }


    }




//------------------------------------------------------------------------
//        return new ResponseEntity<>(detailService.loadUserByUsername(email), HttpStatus.OK);
//    }


}
