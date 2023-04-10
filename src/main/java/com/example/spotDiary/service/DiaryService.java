package com.example.spotDiary.service;

import com.example.spotDiary.dto.DiaryDTO;
import com.example.spotDiary.entity.Diary;

import java.util.List;

public interface DiaryService {

    // 다이어리 목록
    List<DiaryDTO> getAllDiaries();

    // 다이어리 저장
//    DiaryDTO saveDiary(int userId, String content, String emoji);
//
//    // 다이어리 조회
//    Diary getDiaryById(Long id);
//
//    // 다이어리 수정
//    DiaryDTO updateDiary(String content, String emoji);
//
//    // 다이어리 삭제
//    DiaryDTO deleteDiary(Long id);

}
