package com.milind.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milind.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
