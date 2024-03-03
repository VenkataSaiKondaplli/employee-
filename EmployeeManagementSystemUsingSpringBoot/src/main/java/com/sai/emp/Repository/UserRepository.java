package com.sai.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.emp.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
