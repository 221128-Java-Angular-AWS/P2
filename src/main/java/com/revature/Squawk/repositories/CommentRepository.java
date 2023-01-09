package com.revature.Squawk.repositories;

import com.revature.Squawk.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
