package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog

        //get blog, find by id
        Blog blog = blogRepository2.findById(blogId).get();

        //create entity
        Image image = new Image();

        //set attributes of image
        image.setDimensions(dimensions);
        image.setDescription(description);
        image.setBlog(blog);

        //set attributes of blog
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);

        //save
        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        ////get image, find by id
        Image image = imageRepository2.findById(id).get();

        //dimensions
        String dim = image.getDimensions();
        String[] imageDim = dim.split("X");
        String[] screenDim = screenDimensions.split("X");

        //calculate
        int count = (Integer.valueOf(screenDim[0])/Integer.valueOf(imageDim[0])) *(Integer.valueOf(screenDim[1])/Integer.valueOf(imageDim[1]));

        return count;
    }
}
