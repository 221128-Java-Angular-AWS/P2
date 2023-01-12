package com.revature.Squawk.repositories;

import com.revature.Squawk.models.Log;
import java.sql.Timestamp;
import com.revature.Squawk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
