package com.example.spotDiary.controller;

import com.example.spotDiary.domain.dto.DiaryRequestDTO;
import com.example.spotDiary.domain.dto.DiaryResponseDTO;
import com.example.spotDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    // 다이어리 list view
    @GetMapping("/lists")
    public List<DiaryResponseDTO> findAllDiaries() {
        return diaryService.getAllDiaries();
    }

    // 다이어리 작성 view
    @GetMapping("/views/write")
    public String writeDiary() {
        return "/diary/views/write";
    }

    // 다이어리 생성
    @PostMapping("/saves")
    public String saveDiary(@RequestBody final DiaryRequestDTO params) {
        diaryService.saveDiary(params);
        return "redirect:/diary/lists";
    }

    // 다이어리 상세/수정 view
    @GetMapping("/details/{id}")
    public DiaryResponseDTO viewDiary(@PathVariable final Long id) {
        return diaryService.getDiaryById(id);
    }

    // 다이어리 update
    @PutMapping("/updates/{id}")
    public DiaryResponseDTO updateDiary(@PathVariable final Long id, @RequestBody final DiaryRequestDTO params) {
        return diaryService.updateDiary(id, params);
    }

    // 다이어리 삭제 delete
    @DeleteMapping("/deletes/{id}")
    public String deleteDiary(@PathVariable final Long id) {
        diaryService.deleteDiary(id);
        return "redirect:/diary/lists";
    }

}
