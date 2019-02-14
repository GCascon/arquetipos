package com.jacktutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jacktutorial.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByAliasAndPassword(String alias, String password);
	
	@Query("SELECT u FROM User u WHERE u.alias=:alias and u.password=:password")
	List<User> findByQuery(@Param("alias") String alias, @Param("password") String password);
}
