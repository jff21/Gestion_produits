package com.product.product_backend.Services.Impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.product.product_backend.Entities.QrCode;
import com.product.product_backend.Services.QrService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QrServiceImpl implements QrService {
    @Override
    public byte[] generateQR(String qrcode, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try{
            bitMatrix=qrCodeWriter.encode(qrcode, BarcodeFormat.QR_CODE,width,height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
