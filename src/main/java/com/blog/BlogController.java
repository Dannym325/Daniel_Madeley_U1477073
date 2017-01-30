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
 *
 * Controller that looks after all the mapping for blogs.
 */

@Controller
public class BlogController {

    @Autowired
    protected BlogService blogService;

    // maps the user to the new blog page when they click the new blog button.
    @RequestMapping(value = "/newblog", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("blog", new Blog1());
        return "newblog";
    }

    // add new blog
    // mapping for the create blog form, will add a new blogs and then return the user to the index page.
    @RequestMapping(value = "/create/blog", method = RequestMethod.POST)
    public String createBlog(Model model, @Valid @ModelAttribute("blog") Blog1 blog, BindingResult bindingResult){

        blogService.save(blog);

        model.addAttribute("blog", new Blog1());
        model.addAttribute("blogs", blogService.findAll());

        model.addAttribute("type", "success");
        model.addAttribute("message", "A new blog has been created.");

        return "index";
    }

    // delete blog
    // mapping so a user can delete a blog, user is then returend to the index page.
    @RequestMapping(value = "/delete/blog/{blog}", method = RequestMethod.GET)
    public String deleteBlog(Model model, @PathVariable Blog1 blog){

        blogService.delete(blog);

        model.addAttribute("blog", new Blog1());
        model.addAttribute("blogs", blogService.findAll());

        model.addAttribute("type", "success");
        model.addAttribute("message", "The blog has been deleted.");

        return "index";
    }

    // mapping to find a user by id so all the attributes can be added into the edit blog form.
    @RequestMapping(value = "/edit/blog/{blog}", method = RequestMethod.GET)
    public String getBlogByid(Model model, @Valid @ModelAttribute("blog") Blog1 blog){
        model.addAttribute("blog", new Blog1());
        //model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("blog", blogService.getBlogByid(blog.getId()));
        return "editblog";
    }

    // mapping so that once a user has edited a blog, its can be saved back into the database.
    @RequestMapping(value = "/save/edit/{blog}", method = RequestMethod.POST)
    public String editBlog(Model model, @Valid @ModelAttribute("blog") Blog1 blog, BindingResult bindingResult){

        blogService.save(blog);

        model.addAttribute("blog", blog);

        model.addAttribute("blog", new Blog1());
        model.addAttribute("blogs", blogService.findAll());

        model.addAttribute("type", "success");
        model.addAttribute("message", "The blog has been updated.");

        return "index";
    }

    // gets all blogs
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getAllBlogs(Model model){
        model.addAttribute("blog", new Blog1());
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }



}
