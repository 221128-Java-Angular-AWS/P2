package com.revature.Squawk.repositories;

import com.revature.Squawk.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
