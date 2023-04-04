package com.example.spotDiary.service.impl;

import com.example.spotDiary.dto.DiaryDTO;
import com.example.spotDiary.entity.Diary;
import com.example.spotDiary.entity.DiaryRepository;
import com.example.spotDiary.service.DiaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }
    
    // 다이어리 저장
    @Override
    public DiaryDTO saveDiary(int userId, String content, String emoji) {
        return null;
    }

    // 다이어리 가져오기
    @Override
    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id).orElse(null);
    }

    // 다이어리 수정
    @Override
    public DiaryDTO updateDiary(String content, String emoji) {
        return null;
    }

    // 다이어리 삭제
    @Override
    public DiaryDTO deleteDiary(Long id) {
        return null;
    }

    // 다이어리 list 가져오기
    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }
}
