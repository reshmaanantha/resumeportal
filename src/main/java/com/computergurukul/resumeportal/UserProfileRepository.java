package com.computergurukul.resumeportal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computergurukul.resumeportal.models.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
	Optional<UserProfile>findByUserName(String userName);

}
