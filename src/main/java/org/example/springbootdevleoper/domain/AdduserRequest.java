package org.example.springbootdevleoper.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdduserRequest {
    private Long user_id;
    private String email;
    private String password;
    private String passwordCheck;
    private String name;
    private String birthY;
    private String birthM;
    private String birthD;
    private LocalDateTime register_date;

    AdduserRequest(User user){
        this.user_id = user.getUser_id();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.passwordCheck = user.getPasswordCheck();
        this.name = user.getName();
        this.birthY = user.getBirthY();
        this.birthM = user.getBirthM();
        this.birthD = user.getBirthD();
        this.register_date = user.getRegister_date();


    }
}
