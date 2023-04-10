package com.example.spotDiary.controller;

import com.example.spotDiary.dto.DiaryDTO;
import com.example.spotDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryViewController {

    @Autowired
    private DiaryService diaryService;

    // 다이어리 list page
    @GetMapping("/list.do")
    public List<DiaryDTO> findAllDiaries() {
        return diaryService.getAllDiaries();
    }

    // 다이어리 작성 page
    @GetMapping("/write.do")
    public String diaryWrite() {
        return "diary/write";
    }

    // 다이어리 생성
    @PostMapping("/save.do")
    public String saveDiary(@RequestBody final DiaryDTO params) {
        diaryService.saveDiary(params);
        return "redirect:/post/list.do";
    }

}
