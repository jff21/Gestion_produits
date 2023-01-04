package com.product.product_backend.Services;

import com.product.product_backend.DTOS.ProductDTO;

public interface QrService {
    byte[] generateQR(ProductDTO qrcode, int width, int height);
}
