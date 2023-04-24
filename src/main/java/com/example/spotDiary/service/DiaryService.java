package com.example.spotDiary.service;

import com.example.spotDiary.dto.DiaryRequestDTO;
import com.example.spotDiary.dto.DiaryResponseDTO;

import java.util.List;

public interface DiaryService {

    // 다이어리 목록
    List<DiaryResponseDTO> getAllDiaries();

    // 다이어리 저장
    Long saveDiary(DiaryRequestDTO params);

//    // 다이어리 조회
    DiaryResponseDTO getDiaryById(Long id);

//    // 다이어리 수정
    DiaryResponseDTO updateDiary(Long id, DiaryRequestDTO params);
//
//    // 다이어리 삭제
    Long deleteDiary(Long id);

}
