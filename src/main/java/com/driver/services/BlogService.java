package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) throws Exception {
        //create a blog at the current time

        //get user , by id
        User user = userRepository1.findById(userId).get();
        if(user == null) {
            throw new Exception();
        }

        //create entity -> for repo to interact with
        Blog blog = new Blog();

        //set attributes of blog
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);

        //set attributes of user
        user.getBlogList().add(blog);

        //save
        userRepository1.save(user);

        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}