package main.java.com.ebookstore.dao;

import main.java.com.ebookstore.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface UserDao extends CrudRepository<User,Integer> {
    @Query(value = "SELECT * FROM users WHERE user_id=?1", nativeQuery = true)
    User findResource(Integer i);
}
