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

    //

}
