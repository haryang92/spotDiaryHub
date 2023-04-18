package com.example.spotDiary.controller;

import com.example.spotDiary.dto.DiaryRequestDTO;
import com.example.spotDiary.dto.DiaryResponseDTO;
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
    public List<DiaryResponseDTO> findAllDiaries() {
        return diaryService.getAllDiaries();
    }

    // 다이어리 작성 page
    @GetMapping("/write.do")
    public String writeDiary() {
        return "diary/write";
    }

    // 다이어리 생성
    @PostMapping("/save.do")
    public String saveDiary(@RequestBody final DiaryRequestDTO params) {
        diaryService.saveDiary(params);
        return "redirect:/diary/list.do";
    }

    // 다이어리 상세/수정 page
    @GetMapping("/view.do/{id}")
    public DiaryResponseDTO viewDiary(@RequestParam final Long id) {
        return diaryService.getDiaryById(id);
    }

    // 다이어리 update
    @PutMapping("/update.do")
    public String updateDiary() {
        return "diary/update";
    }

    // 다이어리 삭제 delete
    @DeleteMapping("/delete.do/{id}")
    public String deleteDiary(@RequestParam final Long id) {
        diaryService.deleteDiary(id);
        return "redirect:/diary/list.do";
    }

}
