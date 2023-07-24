package com.testapi.leem;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/leeminsung")
    public String site(Model model){
        List<Question> questionList = this.questionService.getlist();
        model.addAttribute("questionlist",questionList);
        return "leeminsung";
    }
    //게시물 등록
    @GetMapping("/leeminsung/create")
    public String create(){
        return "leeminsung_create";
    }

    @PostMapping("/leeminsung/create")
    public String questionCreate(@RequestParam String title, @RequestParam String content) {
        this.questionService.create(title, content);
        return "redirect:/leeminsung";
    }
    //게시물 등록 끝


    //디테일
    @GetMapping("/leeminsung/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "leeminsung_detail";
    }
    //디테일 끝


    // 수정
    @GetMapping("/leeminsung/modify/{id}")
    public String modify(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "leeminsung_modify";
    }
    @PostMapping("/leeminsung/modify/{id}")
    public String questionModify(Question questionForm, BindingResult bindingResult,
                                 @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        this.questionService.modify(question, questionForm.getTitle(), questionForm.getContent());
        return String.format("redirect:/leeminsung/detail/%s", id);
    }

    //수정 끝


    // 삭제


    @GetMapping("/leeminsung/delete/{id}")
    public String questionDelete(@PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        this.questionService.delete(question);
        return "redirect:/leeminsung";
    }






    //삭제 끝
}
