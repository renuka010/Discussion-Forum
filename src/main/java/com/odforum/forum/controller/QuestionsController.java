package com.odforum.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.odforum.forum.entity.Answer;
import com.odforum.forum.entity.EmailDetails;
import com.odforum.forum.entity.Questions;
import com.odforum.forum.entity.User;
import com.odforum.forum.repo.EmailService;
import com.odforum.forum.service.AnswerService;
import com.odforum.forum.service.QuestionsService;
import com.odforum.forum.service.UserService;
import com.odforum.forum.validation.Validator;

@Controller
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private Validator validator;
	
	@RequestMapping("/login")
	public String loginPage() {
		return "Login";
	}
	
	@GetMapping("/")
	public ModelAndView getQuestions(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		ModelAndView mav=new ModelAndView();
		mav.addObject("questions", questionService.getQuestions());
		mav.addObject("userid",auth.getName());
		mav.addObject("option","New");
		mav.setViewName("UserHome");
		return mav;
	}
	
	@GetMapping("/lastweek")
	public ModelAndView getLastWeekQuestions(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		ModelAndView mav=new ModelAndView();
		mav.addObject("questions", questionService.getLastWeekQues());
		mav.addObject("userid",auth.getName());
		mav.addObject("option","Top(Last 1 week)");
		mav.setViewName("UserHome");
		return mav;
	}
	
	@GetMapping("/lastmonth")
	public ModelAndView getLastMonthQuestions(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		ModelAndView mav=new ModelAndView();
		mav.addObject("questions", questionService.getLastMonthQues());
		mav.addObject("userid",auth.getName());
		mav.addObject("option","Top(Last 1 month)");
		mav.setViewName("UserHome");
		return mav;
	}
	
	@GetMapping("/lastyear")
	public ModelAndView getLastYearQuestions(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		ModelAndView mav=new ModelAndView();
		mav.addObject("questions", questionService.getLastYearQues());
		mav.addObject("userid",auth.getName());
		mav.addObject("option","Top(Last 1 year)");
		mav.setViewName("UserHome");
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getQuestion(@PathVariable Long id){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
		
		if(auth.getName().toString().equals("anonymousUser")) {
			mav.setViewName("Login");
			return mav;
		}
		mav.addObject("quesDto",questionService.getQuestion(id));
		mav.addObject("userid",auth.getName());
		mav.setViewName("ViewThread");
		return mav;
	}
	
	@RequestMapping("/ask")
	public ModelAndView askQuestion() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mav=new ModelAndView();
		mav.addObject("userid",auth.getName());
		mav.setViewName("Ask");
		return mav;
	}
	
	@PostMapping("/add")
	public ModelAndView createQuestion(Questions Questions, Model m) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Questions.setUserId(auth.getName().toString());
		questionService.createQuestion(Questions);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("userid",auth.getName());
		mav.addObject("message", "Added Successfully");
		mav.setViewName("Ask");
		return mav;
	}
	
	@GetMapping("/change-password")
	public ModelAndView getAccount(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("userid",auth.getName());
		mav.setViewName("MyAccount");
		return mav;
	}
		
	@RequestMapping("/change-password/update")
	public ModelAndView UpdatePassword(@RequestParam String old, @RequestParam String new1, @RequestParam String new2){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user=userService.getAccount(auth.getName().toString());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("userid",auth.getName());
		mav.setViewName("MyAccount");
		
		if(!encoder.matches(old, user.getPassword()))
			mav.addObject("message", "Old Password doesn't match");
		else if(!new1.equals(new2))
			mav.addObject("message", "New Passwords doesn't match");
		else if(!validator.validatePassword(new1)) {
			mav.addObject("message", "Password should have atleast one uppercase letter, lowercase letter, symbols and number. Minimum length is 8");
		}
		else
		{
			mav.addObject("message", "Updated Successfully");
			user.setPassword(encoder.encode(new1));
			userService.updateAccount(user);
		}
		return mav;
	}
	
	@GetMapping("/register")
	public String registerUser() {
		return "Registration";
	}
	
	//delete mapping
	@GetMapping("/{id}/delete")
	public String deleteQuestion(@PathVariable Long id, Model m) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth.getName().toString().equals("anonymousUser")) {
			return "redirect:/login";
		}
		
		answerService.deleteAnswers(id);
		questionService.deleteQuestion(id);
		
		m.addAttribute("userid", auth.getName());
		return "Message";
	}
	
	//delete mapping answer
	@GetMapping("/del")
	public ModelAndView deleteAnswer(@RequestParam Long id,@RequestParam Long qid) {
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
			
		if(auth.getName().toString().equals("anonymousUser")) {
			mav.setViewName("redirect:/login");
			return mav;
		}
			
		answerService.deleteAnswer(id);
			
		mav.addObject("userid", auth.getName());
		mav.addObject("quesDto",questionService.getQuestion(qid));
		mav.setViewName("ViewThread");
		return mav;
	}
	
	@PostMapping("/{id}")
	public ModelAndView createAnswer(Answer answer) {
		
		answerService.createAnswer(answer);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("quesDto",questionService.getQuestion(answer.getQuesId()));
		mav.addObject("userid",auth.getName());
		mav.setViewName("ViewThread");
		return mav;
	}
	
	@PostMapping("/newuser")
	public ModelAndView createUser(@RequestParam String username,@RequestParam String emailId,@RequestParam String password1,@RequestParam String password2) {
		
		ModelAndView mav=new ModelAndView();
		
		username=username.toLowerCase();
		
		if(!password1.equals(password2)) {
			mav.addObject("message", "Passwords don't match");
			mav.setViewName("Registration");
		}
		else if(!validator.validatePassword(password2)) {
			mav.addObject("message", "Password should have atleast one uppercase letter, lowercase letter, symbols and number. Minimum length is 8");
			mav.setViewName("Registration");
		}
		else if(userService.getUserDetails(emailId)!=null) {
			mav.addObject("message", "Email ID is already registered");
			mav.setViewName("Registration");
		}
		else if(userService.getAccount(username)!=null) {
			mav.addObject("message", "Username already taken");
			mav.setViewName("Registration");
		}
		else if(!validator.validateUsername(username)) {
			mav.addObject("message", "Username can have only letters, numbers or underscore. Should start with a letter. Minimum length is 6.");
			mav.setViewName("Registration");
		}
		else{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userService.createUser(username,emailId,encoder.encode(password2).toString());
			mav.setViewName("Login");
		}
		return mav;
	}
	
	@GetMapping("/myactivity")
	public ModelAndView myActivities() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("activityDto",questionService.getActivities(auth.getName().toString()));
		mav.addObject("userid",auth.getName());
		mav.setViewName("MyActivity");
		return mav;
		
	}
	
	@GetMapping("/forgetpwd")
	public ModelAndView forgetpwd() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("code","email");
		mav.setViewName("ForgetPassword");
		return mav;
	}
	
	@GetMapping("/getotp")
	public ModelAndView forgetpwdpost(@RequestParam String emailId)
    {
		User user=userService.getUserDetails(emailId);
		
		ModelAndView mav=new ModelAndView();
		
		if(user==null) {
			mav.addObject("code","email");
			mav.addObject("msg","No such email Id found");
			mav.setViewName("ForgetPassword");
		}
		else {
			EmailDetails details = new EmailDetails();
			details.setRecipient(emailId);
			String otp= emailService.sendSimpleMail(details);
		
			mav.addObject("code","otp");
			mav.addObject("otp",otp);
			mav.addObject("emailid",emailId);
			mav.setViewName("ForgetPassword");
		}
		return mav;
	}
	
	@PostMapping("/otp")
	public ModelAndView enterotp(@RequestParam String otp1,@RequestParam String emailid,@RequestParam String otp2) {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("emailid",emailid);
		if(otp1.equals(otp2)) {
			mav.addObject("code","changepwd");
		}
		else {
			mav.addObject("code","otp");
			mav.addObject("otp",otp1);
			mav.addObject("msg","Wrong OTP");
		}
		mav.setViewName("ForgetPassword");
		return mav;
	}
	
	@PostMapping("/changepwd")
	public ModelAndView changepwd(@RequestParam String emailid,@RequestParam String pwd1,@RequestParam String pwd2) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		User user=userService.getUserDetails(emailid);
		
		ModelAndView mav=new ModelAndView();

		if(!pwd1.equals(pwd2)) {
			mav.addObject("code","changepwd");
			mav.addObject("emailid",emailid);
			mav.addObject("message", "New Passwords doesn't match");
			mav.setViewName("ForgetPassword");
		}
		else if(!validator.validatePassword(pwd1)) {
			mav.addObject("code","changepwd");
			mav.addObject("emailid",emailid);
			mav.addObject("message", "Password should have atleast one uppercase letter, lowercase letter, symbols and number. Minimum length is 8");
			mav.setViewName("ForgetPassword");
		}
		else
		{
			mav.addObject("message", "Password changed successfully");
			mav.setViewName("redirect:/login");
			user.setPassword(encoder.encode(pwd1));
			userService.updateAccount(user);
		}
		
		return mav;
	}
	
	@GetMapping("/search")
	public ModelAndView seachQues(@RequestParam String keyword) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("questions", questionService.SearchQuestions(keyword));
		mav.addObject("userid",auth.getName());
		mav.setViewName("SearchResults");
		return mav;
		
	}
}
