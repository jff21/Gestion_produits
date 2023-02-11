package com.product.product_backend.Services;

import com.google.zxing.WriterException;
import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.DTOS.ProductQRDTO;
import com.product.product_backend.DTOS.QRcodeDTO;
import com.product.product_backend.Models.QrCode;

import java.io.IOException;
import java.io.OutputStream;

public interface QrService {
    byte[] generateQR(ProductQRDTO productDTO, int width, int height);
    QrCode saveQrcode(QRcodeDTO qRcodeDTO,ProductQRDTO productQRDTO, int width, int height);
   // byte[] generatedQr(ProductDTO productDTO, OutputStream outputStream) throws WriterException, IOException;
}
