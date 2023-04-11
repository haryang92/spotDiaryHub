package com.example.spotDiary.service;

import com.example.spotDiary.dto.DiaryRequestDTO;
import com.example.spotDiary.dto.DiaryResponseDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface DiaryService {

    // 다이어리 목록
    List<DiaryResponseDTO> getAllDiaries();

    // 다이어리 저장
    @Transactional
    Long saveDiary(DiaryRequestDTO params);

//    // 다이어리 조회
    DiaryResponseDTO getDiaryById(Long id);

//    // 다이어리 수정
    @Transactional
    public Long updateDiary(final Long id, final DiaryRequestDTO params);
//
//    // 다이어리 삭제
//    DiaryDTO deleteDiary(Long id);

}
