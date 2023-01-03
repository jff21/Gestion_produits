package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.Services.QrService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Qr")
@AllArgsConstructor
public class QRcodeController {

    private static final int WIDTH =500 ;
    private static final int HEIGHT =500 ;
    private final QrService qrService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]>getQrCode(@RequestBody ProductDTO productDTO){
        String contentToGenerateQrCode="simple solution";
        byte[] qrCode = qrService.generateQR(contentToGenerateQrCode,WIDTH,HEIGHT, productDTO.getPro_id());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }

}
