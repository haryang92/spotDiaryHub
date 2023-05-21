package com.example.spotDiary.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                        // pk
    private int userId;                                     // 사용자id
    private String content;                                 // 내용
    private String emoji;                                   // 이모티콘
    private LocalDateTime createdAt = LocalDateTime.now();  // 생성일
    private LocalDateTime updatedAt;                        // 수정일
    private LocalDateTime deletedAt;                        // 삭제일

    @Builder
    public Diary(int userId, String content, String emoji) {
        this.userId = userId;
        this.content = content;
        this.emoji = emoji;
    }

    // 다이어리 수정
    public void update(int userId, String content, String emoji) {
        this.userId = userId;
        this.content = content;
        this.emoji = emoji;
        this.updatedAt = LocalDateTime.now();
    }

    // 다이어리 삭제
    public void delete(){
        this.deletedAt = LocalDateTime.now();;
    }
}

/**
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
    access 속성을 이용해서 동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어합니다.

 * 빌더 패턴은 점층적 생성자 패턴의 안정성과 자바빈즈 패턴의 가독성을 겸비한 패턴이다.
 */