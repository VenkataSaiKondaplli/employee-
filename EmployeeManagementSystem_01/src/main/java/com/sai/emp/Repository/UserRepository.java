package com.sai.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.emp.Model.UserData;

public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUsername(String username);
}
