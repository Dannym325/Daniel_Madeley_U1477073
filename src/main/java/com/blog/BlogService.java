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

}



