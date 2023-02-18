package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Blog")
public class Blog{
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date pubDate;

    //Mapping
    //unidirectional -> Blog: User :: Child: Parent :: Many: One
    @ManyToOne
    @JoinColumn
    private User user;

    //Bidirectional -> Blog: Image :: Parent: Child :: One: Many
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    //constructor
    public Blog() {

    }

    //getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Date getPubDate() { return pubDate; }
    public void setPubDate(Date pubDate) { this.pubDate = pubDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Image> getImageList() { return imageList; }
    public void setImageList(List<Image> imageList) { this.imageList = imageList; }
}