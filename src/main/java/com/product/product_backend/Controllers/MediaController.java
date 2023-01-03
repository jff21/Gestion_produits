//package com.product.product_backend.Controllers;
//
//import com.product.product_backend.Entities.Media;
//import com.product.product_backend.Repositories.MediaRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//
//@RestController
//@Slf4j
//public class MediaController {
//
//    private final MediaRepository mediaRepository;
//
//    public MediaController(MediaRepository mediaRepository) {
//        this.mediaRepository = mediaRepository;
//    }
//
//
//    @PostMapping
//   public Long uploadImage(@RequestParam MultipartFile image)throws Exception{
//        Media dbimage = new Media();
//        dbimage.setNom(image.getName());
//        dbimage.setImage(image.getBytes());
//        log.info("image uploaded");
//        return  mediaRepository.save(dbimage).getId();
//    }
//
//    @GetMapping(value = "/image/{imageId}",produces = MediaType.IMAGE_JPEG_VALUE)
//    ByteArrayResource downloadImage(@PathVariable Long imageId){
//        byte[] image= mediaRepository.findById(imageId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND))
//                .getContent();
//        return new ByteArrayResource(image);
//    }
//}
