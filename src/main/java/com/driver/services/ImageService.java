package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog

        //get blog, find by id
        Blog blog = blogRepository.findById(blogId).get();

        //create entity
        Image image = new Image();

        //set attributes of image
        image.setDimensions(dimensions);
        image.setDescription(description);
        image.setBlog(blog);

        //set attributes of blog
        blog.getImageList().add(image);

        //save
        blogRepository.save(blog);

        return image;
    }


    public void deleteImage(Integer id){
        imageRepository.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        ////get image, find by id
        Image image = imageRepository.findById(id).get();

        //dimensions
        String[] screenDimensionsArr = screenDimensions.split("X");
        String[] imageDimensionsArr = image.getDimensions().split("X");

        int screenLength = Integer.parseInt(screenDimensionsArr[0]);
        int screenBreadth = Integer.parseInt(screenDimensionsArr[1]);

        int imageLength = Integer.parseInt(imageDimensionsArr[0]);
        int imageBreadth = Integer.parseInt(imageDimensionsArr[1]);

        int imagesInLength = screenLength/imageLength;
        int imagesInBreadth = screenBreadth/imageBreadth;

        int totalImages = imagesInLength * imagesInBreadth;

        return totalImages;
    }
}
