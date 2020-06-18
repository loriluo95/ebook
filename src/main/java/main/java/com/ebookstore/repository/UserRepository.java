package main.java.com.ebookstore.repository;

import main.java.com.ebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//public interface UserDao extends CrudRepository<User,Integer> {
//    @Query(value = "SELECT * FROM users WHERE user_id=?1", nativeQuery = true)
//    User findResource(Integer i);
//}

public interface UserRepository extends JpaRepository<User, Integer> {
}
