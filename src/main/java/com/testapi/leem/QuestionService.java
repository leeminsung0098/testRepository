package com.testapi.leem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<Question> getlist(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        question.isPresent();
        return question.get();

    }
    public void create(String title , String content){
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    public void modify(Question question, String title, String content) {
        question.setTitle(title);
        question.setContent(content);
        question.setDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }


    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
