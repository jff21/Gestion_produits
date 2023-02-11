package com.product.product_backend.Formatter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.product.product_backend.DTOS.ProductQRDTO;
import com.product.product_backend.DTOS.QRcodeDTO;
import org.hibernate.MappingException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration

public class QRCodeDTOConverter implements Converter<String, QRcodeDTO> {
    @Override
    public QRcodeDTO convert(String source) {
        try{
            JsonObject jsonObject = new Gson().fromJson(source,JsonObject.class);
            QRcodeDTO qRcodeDTO = new QRcodeDTO();
            qRcodeDTO.setProduct(jsonObject.get("product")==null||jsonObject.get("product").isJsonNull()?null:jsonObject.get("product").getAsLong());
        }catch (Exception e){
            throw  new MappingException("Posting object parse fail");
        }
        return null;
    }
}
