package com.assignment.contactmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.contactmanagement.model.UserContactInfo;

public interface UserContactInfoRepository extends JpaRepository<UserContactInfo, Long>{

	public List<UserContactInfo> findByFirstName(String firstName);

	public List<UserContactInfo> findByLastName(String lastName);

	public UserContactInfo findByMailId(String mailId);

	@Modifying
	@Query("Delete from UserContactInfo u where u.mailId=:mailId")
	public int deleteUserByMailId(@Param("mailId") String mailId);

	public boolean existsByMailId(String mailId);
}
