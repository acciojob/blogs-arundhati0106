package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "Image")
public class Image{
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimensions;

    //mapping
    //unidirectional -> Image: Blog :: Child: Parent :: Many: One
    @ManyToOne
    @JoinColumn
    private Blog blog;

    //constructor
    public Image() {
    }

    //getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    public Blog getBlog() { return blog; }
    public void setBlog(Blog blog) { this.blog = blog; }
}