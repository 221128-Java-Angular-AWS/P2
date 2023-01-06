package com.revature.Squawk.repositories;

import com.revature.Squawk.models.Like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//  a repository is a bean that handles persistence of a specific resource. Must extend JpaRepository
@Repository
@Transactional
public interface LikeRepository extends JpaRepository<Like, Integer> {
    /* these should be implemented for us:
    save()
    saveAll()
    findById() - find like row based on PK like_id
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    // Spring will try to auto create this query, not sure if it will work or not
    //List<Like> findLikesByPostIdAuto(Integer postId);

    // manual query creation, I might prefer this just to have more control over the queries
    // find likes by post id to create a like count for posts
    @Query(value = "SELECT * FROM likes WHERE post_id = :postId", nativeQuery = true)
    List<Like> findLikesByPostId(@Param("postId") Integer postId);

    // set up a find likes by users to get a list of liked posts for that user

}


