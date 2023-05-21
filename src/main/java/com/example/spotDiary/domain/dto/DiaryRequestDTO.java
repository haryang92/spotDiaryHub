package com.example.spotDiary.domain.dto;

import com.example.spotDiary.domain.entity.Diary;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryRequestDTO {

    private int userId;     // 사용자 id
    private String content; // 내용
    private String emoji;   // 이모티콘

    public Diary toEntity() {
        return Diary.builder()
                .userId(userId)
                .content(content)
                .emoji(emoji)
                .build();
    }

}
