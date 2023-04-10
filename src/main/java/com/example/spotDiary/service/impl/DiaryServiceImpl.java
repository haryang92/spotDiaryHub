package com.example.spotDiary.service.impl;

import com.example.spotDiary.dto.DiaryDTO;
import com.example.spotDiary.entity.Diary;
import com.example.spotDiary.entity.DiaryRepository;
import com.example.spotDiary.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }
    // 다이어리 list
    @Override
    public List<DiaryDTO> getAllDiaries() {
        // 코드 간결하게 stream 사용
        List<Diary> diaryList = diaryRepository.findAll();
        return diaryList.stream().map(DiaryDTO::new).collect(Collectors.toList());

        // stream 사용 전
//        List<Diary> entityList = diaryRepository.findAll();
//        List<DiaryDTO> dtoList = new ArrayList<>();
//
//        for (Diary entity : entityList) {
//            dtoList.add(new DiaryDTO(entity));
//        }
    }

}
