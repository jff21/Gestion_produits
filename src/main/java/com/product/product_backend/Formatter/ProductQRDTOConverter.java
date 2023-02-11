package com.product.product_backend.Formatter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.product.product_backend.DTOS.ProductQRDTO;
import org.hibernate.MappingException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration

public class ProductQRDTOConverter  implements Converter<String, ProductQRDTO> {
    @Override
    public ProductQRDTO convert(String source) {
        try{
            JsonObject jsonObject = new Gson().fromJson(source,JsonObject.class);
            ProductQRDTO productQRDTO = new ProductQRDTO();
            productQRDTO.setDescription(jsonObject.get("description")==null||jsonObject.get("description").isJsonNull()?null:jsonObject.get("description").getAsString());
            productQRDTO.setUnitPrice(jsonObject.get("unitPrice")==null||jsonObject.get("unitPrice").isJsonNull()?null:jsonObject.get("unitPrice").getAsInt());
            return productQRDTO;
        }catch (Exception e){
            throw  new MappingException("Posting object parse fail");
        }
    }
}
