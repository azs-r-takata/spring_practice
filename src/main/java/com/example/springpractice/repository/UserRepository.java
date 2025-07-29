package com.example.springpractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springpractice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
//public interface UserRepository {
	    // ユーザー名で完全一致検索
	    List<User> findByUserName(String userName);
}
