package com.assignment.contactmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.contactmanagement.model.UserContactInfo;
import com.assignment.contactmanagement.repository.UserContactInfoRepository;

import jakarta.transaction.Transactional;

@RestController
public class ContactInfoController {

	@Autowired
	private UserContactInfoRepository contactRepo;

	@PostMapping(value="/user")
	public UserContactInfo addNewUser(@RequestBody UserContactInfo user) {
		return contactRepo.save(user);
	}

	@GetMapping(value="/user")
	public List<UserContactInfo> getAllUsers(){
		return contactRepo.findAll();
	}
	
	@GetMapping(value="/test")
	public String testSecurity() {
		return "Hello World!";
	}

	@GetMapping("/userByFirstName/{firstName}")
	public List<UserContactInfo> getAllUsersByFirstName(@PathVariable("firstName") String first){
		return contactRepo.findByFirstName(first);
	}

	@GetMapping("/userByLastName/{lastName}")
	public List<UserContactInfo> getAllUsersByLastName(@PathVariable("lastName") String last){
		return contactRepo.findByLastName(last);
	}

	@GetMapping("/userByMail/{mailId}")
	public UserContactInfo getAllUsersByMail(@PathVariable("mailId") String mail){
		return contactRepo.findByMailId(mail);
	}

	@PutMapping("/user/{mailId}")
	public UserContactInfo updateUserByMail(@RequestBody UserContactInfo newUser,
			@PathVariable("mailId") String mail) {

		UserContactInfo previousUserInfo = contactRepo.findByMailId(mail);

		previousUserInfo.setFirstName(newUser.getFirstName());
		previousUserInfo.setLastName(newUser.getLastName());
		previousUserInfo.setMailId(newUser.getMailId());

		return contactRepo.save(previousUserInfo);
	}

	@DeleteMapping("/user/{mailId}")
	@Transactional
	public UserContactInfo removeUserById(@PathVariable("mailId") String mail) {
		if(!contactRepo.existsByMailId(mail)){
			return null;
		} else {
			UserContactInfo userDeleted = contactRepo.findByMailId(mail);
			contactRepo.deleteUserByMailId(mail);
			return userDeleted;
		}
	}
}
