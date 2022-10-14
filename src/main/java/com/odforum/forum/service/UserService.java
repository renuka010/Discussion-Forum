package com.odforum.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odforum.forum.entity.User;
import com.odforum.forum.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo  userRepo;		

	public User getAccount(String user) {
		return userRepo.findByUsername(user);
	}

	public void updateAccount(User user) {
		userRepo.save(user);
	}

	public void createUser(String username, String emailId, String password) {
		String pic="C:\\Users\\renuk\\Downloads\\default-user.jpg";
		User user=new User(null,username,password,emailId,pic);
		userRepo.save(user);
	}

	public User getUserDetails(String emailId) {
		List<User> users=userRepo.findAllByEmailId(emailId);
		if(users.size()==0)
			return null;
		return users.get(0);
	}

}
