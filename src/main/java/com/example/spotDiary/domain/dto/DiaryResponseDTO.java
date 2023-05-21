package com.example.spotDiary.domain.dto;

import com.example.spotDiary.domain.entity.Diary;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryResponseDTO {

    private Long id;                  // pk
    private int userId;               // 사용자id
    private String content;           // 내용
    private String emoji;             // 이모티콘
    private LocalDateTime createdAt;  // 생성일
    private LocalDateTime updatedAt;  // 수정일
    private LocalDateTime deletedAt;  // 삭제일

    @Builder
    public DiaryResponseDTO(Diary entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.content = entity.getContent();
        this.emoji = entity.getEmoji();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.deletedAt = entity.getDeletedAt();
    }
}
