package com.example.spotDiary.dto;

import com.example.spotDiary.entity.Diary;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DiaryDTO {

    private Long id; // pk
    private int userId; // 사용자id
    private String content; // 내용
    private String emoji; // 이모티콘
    private LocalDateTime createdAt; // 생성일
    private LocalDateTime updatedAt; // 수정일
    private LocalDateTime deletedAt; // 삭제일

    public Diary diaryEntity(){
        return Diary.builder()
                .userId(userId)
                .content(content)
                .emoji(emoji)
                .build();
    }
}
