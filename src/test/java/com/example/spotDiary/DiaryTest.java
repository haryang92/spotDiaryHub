package com.example.spotDiary;

import com.example.spotDiary.entity.Diary;
import com.example.spotDiary.entity.DiaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DiaryTest {

    @Autowired
    DiaryRepository diaryRepository;

    @Test
    void save() {

        // 1. 게시글 파라미터 생성
        Diary params = Diary.builder()
                .userId(1)
                .content("오늘의 다이어리")
                .emoji("맛있당")
                .build();

        // 2. 게시글 저장
        diaryRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Diary entity = diaryRepository.findById((long) 8).get();
    }

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long boardsCount = diaryRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Diary> boards = diaryRepository.findAll();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        Diary entity = diaryRepository.findById((long) 8).get();

        // 2. 게시글 삭제
        diaryRepository.delete(entity);
    }


}
