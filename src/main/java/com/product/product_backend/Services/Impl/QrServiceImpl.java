package com.product.product_backend.Services.Impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.Models.Product;
import com.product.product_backend.Models.QrCode;
import com.product.product_backend.Repositories.ProductRepo;
import com.product.product_backend.Services.QrService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class QrServiceImpl implements QrService {
 private final ProductRepo productRepo;

    public QrServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public byte[] generateQR(ProductDTO productDTO, int width, int height) {
        QrCode qrCode = new QrCode();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try{
            bitMatrix=qrCodeWriter.encode(String.valueOf(productDTO), BarcodeFormat.QR_CODE,width,height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
