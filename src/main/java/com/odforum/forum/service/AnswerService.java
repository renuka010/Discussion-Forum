package com.odforum.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odforum.forum.entity.Answer;
import com.odforum.forum.repo.AnswerRepo;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepo answerRepo;
	
	public void createAnswer(Answer answer) {
		answerRepo.saveAnswer(answer.getQuesId(),answer.getUserId(),answer.getBody());
		
	}

	public void deleteAnswers(Long id) {
		answerRepo.deleteAllByQuesId(id);
	}

	public void deleteAnswer(Long id) {
		answerRepo.deleteById(id);
	}

}
