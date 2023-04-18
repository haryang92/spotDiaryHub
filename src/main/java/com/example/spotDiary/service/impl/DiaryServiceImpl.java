package com.example.spotDiary.service.impl;

import com.example.spotDiary.dto.DiaryRequestDTO;
import com.example.spotDiary.dto.DiaryResponseDTO;
import com.example.spotDiary.entity.Diary;
import com.example.spotDiary.entity.DiaryRepository;
import com.example.spotDiary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;
//    public DiaryServiceImpl(DiaryRepository diaryRepository) {
//        this.diaryRepository = diaryRepository;
//    }
//    @RequiredArgsConstructor = 이것이 위에 final로 선언된 모든 멤버변수에 기본 생성자를 대신해 만들어 준다.

    // 다이어리 list
    @Override
    public List<DiaryResponseDTO> getAllDiaries() {
        // 코드 간결하게 stream 사용
        List<Diary> diaryList = diaryRepository.findAll();
        return diaryList.stream().map(DiaryResponseDTO::new).collect(Collectors.toList());

        // stream 사용 전
//        List<Diary> entityList = diaryRepository.findAll();
//        List<DiaryDTO> dtoList = new ArrayList<>();
//
//        for (Diary entity : entityList) {
//            dtoList.add(new DiaryDTO(entity));
//        }
    }

    // 다이어리 신규 저장
    @Override
    public Long saveDiary(final DiaryRequestDTO params) {
        Diary entity = diaryRepository.save(params.toEntity());
        return entity.getId();
    }

    // 다이어리 상세
    @Override
    public DiaryResponseDTO getDiaryById(Long id) {
        Diary entity = diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new DiaryResponseDTO(entity);
    }

    // 다이어리 수정
    @Override
    public Long updateDiary(Long id, DiaryRequestDTO params) {
        Diary entity = diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        entity.update(params.getUserId(), params.getContent(), params.getEmoji());
        return id;
    }

    @Override
    public Long deleteDiary(final Long id) {
        Diary entity = diaryRepository.findById(id).orElseThrow();
        entity.delete();
        return id;
    }
}
