package com.example.spotDiary.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/**
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    해당 클래스의 기본 생성자를 생성해 주는 어노테이션입니다.
    access 속성을 이용해서 동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어합니다.
 */
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // pk
    private int userId; // 사용자id
    private String content; // 내용
    private String emoji; // 이모티콘
    private LocalDateTime createdAt = LocalDateTime.now(); // 생성일
    private LocalDateTime updatedAt; // 수정일
    private LocalDateTime deletedAt; // 삭제일

    @Builder
    public Diary(int userId, String content, String emoji) {
        this.userId = userId;
        this.content = content;
        this.emoji = emoji;
    }
}
