package com.product.product_backend.Services.Impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.DTOS.ProductQRDTO;
import com.product.product_backend.DTOS.QRcodeDTO;
import com.product.product_backend.Models.QrCode;
import com.product.product_backend.Repositories.ProductRepo;
import com.product.product_backend.Repositories.QrRepo;
import com.product.product_backend.Services.QrService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class QrServiceImpl implements QrService {
 private final ProductRepo productRepo;
 private final QrRepo qrRepo;

    public QrServiceImpl(ProductRepo productRepo, QrRepo qrRepo) {
        this.productRepo = productRepo;
        this.qrRepo = qrRepo;
    }

    @Override
    public byte[] generateQR(ProductQRDTO productDTO, int width, int height) {
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

    @Override
    public QrCode saveQrcode(QRcodeDTO qRcodeDTO,ProductQRDTO productQRDTO, int width, int height) {
        QrCode qrCode = new QrCode();
        qrCode.setCode_url(generateQR(productQRDTO,width,height));
        return qrRepo.save(qrCode);
    }
}
