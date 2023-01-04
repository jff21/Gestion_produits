//package com.product.product_backend.Controllers;
//
//import com.product.product_backend.Entities.Media;
//import com.product.product_backend.Repositories.MediaRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.IOException;
//
//@RestController
//@Slf4j
//public class MediaController {

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

//    private MediaRepository mediaRepository;
//
//@PostMapping("/upload/image")
//public ResponseEntity<Media> uplaodImage(@RequestParam("image") MultipartFile file)
//        throws IOException {
//
//        mediaRepository.save(Media.builder()
//        .name(file.getOriginalFilename())
//        .type(file.getContentType())
//        .image(ImageUtility.compressImage(file.getBytes())).build());
//        return ResponseEntity.status(HttpStatus.OK)
//        .body(new ImageUploadResponse("Image uploaded successfully: " +
//        file.getOriginalFilename()));
//        }
//
//@GetMapping(path = {"/get/image/info/{name}"})
//public Image getImageDetails(@PathVariable("name") String name) throws IOException {
//
//final Optional<Image> dbImage = imageRepository.findByName(name);
//
//        return Image.builder()
//        .name(dbImage.get().getName())
//        .type(dbImage.get().getType())
//        .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
//        }
//
//@GetMapping(path = {"/get/image/{name}"})
//public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
//
//final Optional<Image> dbImage = imageRepository.findByName(name);
//
//        return ResponseEntity
//        .ok()
//        .contentType(MediaType.valueOf(dbImage.get().getType()))
//        .body(ImageUtility.decompressImage(dbImage.get().getImage()));
//        }