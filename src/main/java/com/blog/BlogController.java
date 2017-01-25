package com.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.blog.Blog;
import com.blog.BlogService;

/**
 * Created by Danny Madeley on 24/01/17.
 */

@Controller
public class BlogController {

    protected BlogService blogService;

    @RequestMapping(value = "/newblog", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("blog", new Blog());
        return "newblog";
    }

    // create new blog
    @RequestMapping(value = "/create/blog", method = RequestMethod.POST)
    public String createBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult){

        blogService.save(blog);

        model.addAttribute("blog", new Blog());
        model.addAttribute("blogs", blogService.findAll());

        model.addAttribute("type", "success");
        model.addAttribute("message", "A new blog has been created.");

        return "result";
    }


    // delete blog

    // edit blog

    // get all blogs
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getAllBlogs(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }


}