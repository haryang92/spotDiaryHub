package com.example.spotDiary;

import com.example.spotDiary.domain.entity.Diary;
import com.example.spotDiary.repository.DiaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
public class DiaryTest {

    @Autowired
    DiaryRepository diaryRepository;

    @Test
    void findAllDiaries() {
        // 전체 게시글 리스트 조회
        List<Diary> diaryList = diaryRepository.findAll();
    }

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
//        Diary entity = diaryRepository.findById((long) 8).get();
    }

    @Test
    void detail() {
        // 게시글 상세
        Diary entity = diaryRepository.findById(10L).get();
    }

    @Test
    void update() {
        Diary entity = diaryRepository.findById(15L).get();
        entity.update(2,"이번달은 5월", "쏘쏘");
        diaryRepository.save(entity);
    }


    @Test
    void delete() {
        // 1. 게시글 조회
        Diary entity = diaryRepository.findById((long) 7).get();

        // 2. 게시글 삭제
        diaryRepository.delete(entity);
    }


    //    @Test
//    void findAll() {
//
//        // 1. 전체 게시글 수 조회
//        long boardsCount = diaryRepository.count();
//
//        // 2. 전체 게시글 리스트 조회
//        List<Diary> boards = diaryRepository.findAll();
//    }


}
