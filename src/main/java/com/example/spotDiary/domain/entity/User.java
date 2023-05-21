package com.example.spotDiary.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                         // 고유id
    private String userId;                                   // 사용자id
    private String pw;                                       // 패스워드
    private String name;                                     // 이름
    private String email;                                    // 이메일
    private String authenticationToken;                      // 인증 token
    private LocalDateTime createdAt = LocalDateTime.now();   // 가입일
    private LocalDateTime deletedAt;                         // 탈퇴일

    @Builder
    public User(Long id, String userId, String pw, String name, String email, String token) {
        this.id = id;
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.authenticationToken = token;
    }

    // 비밂번호검증
    public boolean checkPassword(String pw){
        return this.pw.equals(pw);
    }

}
