package com.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * Created by Danny Madeley on 23/01/17.
 */
public interface BlogRepository extends JpaRepository<Blog1, Long> {

    List<Blog1> findByCategory(String category);
    
}
