package com.product.product_backend.Controllers;

import com.google.zxing.WriterException;
import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.DTOS.ProductQRDTO;
import com.product.product_backend.DTOS.QRcodeDTO;
import com.product.product_backend.Models.QrCode;
import com.product.product_backend.Services.QrService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("Qr")
@AllArgsConstructor
public class QRcodeController {

    private static final int WIDTH =500 ;
    private static final int HEIGHT =500 ;
    private final QrService qrService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]>getQrCode(@RequestBody ProductQRDTO productDTO){
        ProductQRDTO contentToGenerateQrCode=productDTO;
        byte[] qrCode = qrService.generateQR(productDTO,WIDTH,HEIGHT);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }


    @PostMapping("/save")
    public ResponseEntity<QrCode> saveQr(@RequestParam QRcodeDTO qRcodeDTO,@RequestParam ProductQRDTO productQRDTO,@RequestParam  int width, @RequestParam  int height){
        return new ResponseEntity<>(qrService.saveQrcode(qRcodeDTO, productQRDTO, width, height), HttpStatus.CREATED);
    }
}
