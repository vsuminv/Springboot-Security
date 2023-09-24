package org.example.springbootdevleoper.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User implements UserDetails { //UserDetails를 상속받아 인증 객체로 사용
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long user_id;

    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @Column(name="password" , nullable = false)
    private String password;


    @Column(name="passwordCheck")
    private String passwordCheck;


    @Column(name="name" )
    private String name;

    @Column(name="birthY")
    private String birthY;

    @Column(name="birthM")
    private String birthM;

    @Column(name="birthD")
    private String birthD;

    @CreatedDate
    private LocalDateTime register_date;

    @Builder
    public User(Long user_id, String email, String password, String passwordCheck, String name, String birthY, String birthM, String birthD, LocalDateTime register_date, String auth) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.birthY = birthY;
        this.birthM = birthM;
        this.birthD = birthD;
        this.register_date = register_date;
    }

    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override // 사용자 id 반환
    public String getUsername() {
        return email;
    }

    @Override //사용자 패스워드 반환
    public String getPassword() {
        return password;
    }


    // 계정이 만료 되었는지 (true: 만료X)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겼는지 (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되었는지 (true: 만료X)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 계정이 활성화(사용가능)인지 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }




}
