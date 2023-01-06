package com.revature.Squawk.repositories;

import com.revature.Squawk.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {
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

    // could create queries here but it is not necessary for my testing right now
}
