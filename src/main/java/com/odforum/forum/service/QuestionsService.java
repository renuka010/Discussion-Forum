package com.odforum.forum.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odforum.forum.dto.ActivityDto;
import com.odforum.forum.dto.QuestionsDto;
import com.odforum.forum.entity.Answer;
import com.odforum.forum.entity.Questions;
import com.odforum.forum.repo.AnswerRepo;
import com.odforum.forum.repo.QuestionsRepo;

@Service
public class QuestionsService {

	@Autowired
	private QuestionsRepo questionsRepo;
	@Autowired
	private AnswerRepo answerRepo;

	public List<Questions> getQuestions() {
		return questionsRepo.findAllOrderByDatedDesc();
	}

	public QuestionsDto getQuestion(Long id) {
		Optional<Questions> q=questionsRepo.findById(id);
		Questions question=q.get();
		List<Answer> answers=answerRepo.findAllByQuesId(id);
		
		QuestionsDto questionsDto=new QuestionsDto();
		questionsDto.setId(question.getId());
		questionsDto.setUserId(question.getUserId());
		questionsDto.setTitle(question.getTitle());
		questionsDto.setBody(question.getBody());
		questionsDto.setDated(question.getDated());
		questionsDto.setAnswers(answers);
		
		return questionsDto;
	}

	
	public void createQuestion(Questions q) {
		
		//validation
		
		questionsRepo.saveQuestion(q.getUserId(),q.getTitle(),q.getBody());
	}

	public void deleteQuestion(Long id) {
		questionsRepo.deleteById(id);;
	}

	public List<ActivityDto> getActivities(String userId) {
		
		List<Questions> ques=questionsRepo.findAllByUserIdOrderByDatedDesc(userId);
		List<Answer> ans=answerRepo.findAllByUserId(userId);
		List<ActivityDto> activityDto=new ArrayList<>();
		
		for(Questions q:ques) {
			ActivityDto dto=new ActivityDto();
			dto.setQuesId(q.getId());
			dto.setTitle(q.getTitle());
			dto.setBody(q.getBody());
			dto.setDated(q.getDated());
			activityDto.add(dto);
		}
		
		for(Answer a:ans) {
			ActivityDto dto=new ActivityDto();
			dto.setQuesId(a.getQuesId());
			dto.setBody(a.getBody());
			dto.setDated(a.getDated());
			activityDto.add(dto);
		}
		
		Collections.sort(activityDto);
		return activityDto;
	}

	public List<Questions> getLastWeekQues() {
		
		return questionsRepo.findLastWeekQues();
	}

	public List<Questions> getLastMonthQues() {

		return questionsRepo.getLastMonthQues();
	}

	public List<Questions> getLastYearQues() {
		
		return questionsRepo.getLastYearQues();
	}

	public Object SearchQuestions(String keyword) {
		
		return questionsRepo.searchQues(keyword);
	}
	
	
	
}
