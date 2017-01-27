package com.blog;

import com.blog.Blog;
import com.blog.BlogRepository;
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

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    public void update(Blog blog) {
        //blogRepository.saveAndFlush();
    }

    /**
     * Return a blog object by an id.
     * @param id - ID of the blog that is to be returned
     * @return - Blog object
     */
    public Blog getBlogByid(Long id) {
        return blogRepository.findOne(id);
    }


}



