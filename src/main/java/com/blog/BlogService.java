package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Danny Madeley on 23/01/17.
 */
@Service
public class BlogService {

    @Autowired
    protected BlogRepository blogRepository;

    public List<Blog1> findAll() {
        return blogRepository.findAll();
    }


    public Blog1 save(Blog1 blog) {
        return blogRepository.save(blog);
    }

    public void delete(Blog1 blog) {
        blogRepository.delete(blog);
    }

    /**
     * Return a blog object by an id.
     * @param id - ID of the blog that is to be returned
     * @return - Blog object
     */
    public Blog1 getBlogByid(Long id) {
        return blogRepository.findOne(id);
    }

    public List<Blog1> getAllBlogsInCategory(String category) {
        return blogRepository.findByCategory(category);

    }


}



