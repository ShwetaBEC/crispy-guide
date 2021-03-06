package com.ymedialabs.ci.cd.sample.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymedialabs.ci.cd.sample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=:email")
	public Optional<User> findByEmailId(@Param("email") String email);

}
