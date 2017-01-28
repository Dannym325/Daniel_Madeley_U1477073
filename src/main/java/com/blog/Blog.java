package com.blog;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny Madeley on 23/01/17.
 *
 * Blog class to represent the blog entity in the database.
 */

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title; // title of the blog

    @NotEmpty
    private String username; // username who posted the blog

    @NotEmpty
    private String content; // the actual blog

    @NotEmpty
    private int categoryIndex; // an id in which the blog can be categorised to

    public Long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryid()
    {
        return categoryIndex;
    }

    public void getCategoryid(int categoryIndex)
    {
        this.categoryIndex = categoryIndex;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    @OneToMany
    private List<Blog> blogs = new ArrayList<Blog>();


}
