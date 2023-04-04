package com.example.spotDiary.controller;

import com.example.spotDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    private DiaryService diaryService;

    // 다이어리 작성
    @GetMapping("/write.do")
    public String diaryWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
//        if (id != null) {
//            PostResponse post = diaryService.findPostById(id);
//            model.addAttribute("post", post);
//        }
        return "diary/write";
    }

    // 메인 페이지


}
