package com.blog;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny Madeley on 23/01/17.
 */

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String username;

    @NotEmpty
    private String content;

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

    public List<Blog> getBlogs() {
        return blogs;
    }

    @OneToMany
    private List<Blog> blogs = new ArrayList<Blog>();


}
