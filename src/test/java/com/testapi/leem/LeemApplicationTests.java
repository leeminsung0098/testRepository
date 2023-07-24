package com.testapi.leem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Provider;
import java.time.LocalDateTime;


@SpringBootTest
class LeemApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
		Question q1 = new Question();
		q1.setTitle("테스트용 제목");
		q1.setContent("테스트용 내용");
		q1.setMaker("홍길동");
		q1.setDate(LocalDateTime.now());
		q1.setView("0");
		q1.setGood("0");
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setTitle("테스트용 제목2");
		q2.setContent("테스트용 내용2");
		q2.setMaker("홍길동");
		q2.setDate(LocalDateTime.now());
		q2.setView("0");
		q2.setGood("0");
		this.questionRepository.save(q2);
	}

}
