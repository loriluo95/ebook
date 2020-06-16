package main.java.com.ebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.ebookstore.model.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<Users, Integer> {

}
