package com.odforum.forum.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odforum.forum.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	User findByUsername(String username);

	List<User> findAllByEmailId(String emailId);

	

}
