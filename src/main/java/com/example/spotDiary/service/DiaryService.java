package com.example.spotDiary.service;

import com.example.spotDiary.domain.dto.DiaryRequestDTO;
import com.example.spotDiary.domain.dto.DiaryResponseDTO;
import com.example.spotDiary.domain.entity.Diary;
import com.example.spotDiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
/**
 * 실제 DB에 접근하는 Repository를 사용하는 Service에서는@Transaction 어노테이션을 추가해야 한다 (반드시!)
 * 모든 DB관련 작업은 Transaction단위로 수행되며 정상 종료되면 커밋하며, 예외 발생시 롤백해야 한다
 */
public class DiaryService {

    private final DiaryRepository diaryRepository;

    // 다이어리 목록
    public List<DiaryResponseDTO> getAllDiaries() {
        // 코드 간결하게 stream 사용
        List<Diary> diaryList = diaryRepository.findAll();
        return diaryList.stream().map(DiaryResponseDTO::new).collect(Collectors.toList());
    }

    // 다이어리 저장
    public Long saveDiary(final DiaryRequestDTO params) {
        Diary entity = diaryRepository.save(params.toEntity());
        return entity.getId();
    }

    // 다이어리 조회
    public DiaryResponseDTO getDiaryById(Long id) {
        Diary entity = diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new DiaryResponseDTO(entity);
    }

    // 다이어리 수정
    public DiaryResponseDTO updateDiary(Long id, DiaryRequestDTO params) {
        Diary entity = diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        entity.update(params.getUserId(), params.getContent(), params.getEmoji());
    //        DiaryResponseDTO responseDTO = new DiaryResponseDTO.DiaryResponseDTOBuilder()
    //                .userId(id)
    //                .content(entity.getContent())
    //                .emoji(entity.getEmoji())
    //                .build();
        return new DiaryResponseDTO(entity);
    }

    // 다이어리 삭제
    public Long deleteDiary(final Long id) {
        Diary entity = diaryRepository.findById(id).orElseThrow();
        entity.delete();
        return id;
    }

}
