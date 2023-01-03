package com.product.product_backend.Services;

public interface QrService {
    byte[] generateQR(String qrcode,int width,int height);
}
