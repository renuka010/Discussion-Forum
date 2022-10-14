package com.odforum.forum.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.odforum.forum.entity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long>{

	String createquery="insert into answer (ques_id, user_id, body, dated) values(?,?,?,DEFAULT)";
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value=createquery)
	void saveAnswer(Long ques_id, String user_id, String body);

	List<Answer> findAllByQuesId(Long id);

	List<Answer> findAllByUserId(String userId);

	@Modifying
	@Transactional
	void deleteAllByQuesId(Long id);


}
