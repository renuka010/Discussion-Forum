package com.odforum.forum.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.odforum.forum.entity.Questions;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Long>{

	String createquery="insert into questions (user_id, title, body, dated) values(?,?,?,DEFAULT)";
	String lastweek="SELECT * FROM questions WHERE dated BETWEEN  date_add(now(), interval -7 day) and now() order by dated desc";
	String lastmonth="SELECT * FROM questions WHERE dated BETWEEN  date_add(now(), interval -1 month) and now() order by dated desc";
	String lastyear="SELECT * FROM questions WHERE dated BETWEEN  date_add(now(), interval -1 year) and now() order by dated desc";
	String search="SELECT * FROM questions WHERE MATCH(title,body) AGAINST (?)";
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value=createquery)
	void saveQuestion(String user_id,String title,String body);

	List<Questions> findAllByUserIdOrderByDatedDesc(String userId);

	@Query(nativeQuery=true, value=lastweek)
	List<Questions> findLastWeekQues();

	@Query(nativeQuery=true, value=lastmonth)
	List<Questions> getLastMonthQues();

	@Query(nativeQuery=true, value=lastyear)
	List<Questions> getLastYearQues();

	@Query(nativeQuery=true, value=search)
	List<Questions> searchQues(String keyword);

	@Query(nativeQuery=true, value="SELECT * FROM questions ORDER BY dated DESC")
	List<Questions> findAllOrderByDatedDesc();
}
