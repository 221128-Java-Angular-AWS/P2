package com.revature.Squawk.repositories;

import com.revature.Squawk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users u WHERE u.username = :username and u.password = :password", nativeQuery = true)
    List<User> authUser(
            @Param("username") String username,
            @Param("password") String password
    );

    @Query(value = "select * from users;", nativeQuery = true)
    List<User> allUsers();


}
