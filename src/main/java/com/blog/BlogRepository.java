package com.blog;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Danny Madeley on 23/01/17.
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
    
}
