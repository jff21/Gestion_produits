package com.product.product_backend.Formatter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.product.product_backend.DTOS.ProductDTO;
import org.hibernate.MappingException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class StringToProductDTOConverter implements Converter<String, ProductDTO> {

    @Override
    public ProductDTO convert(String source) {
        try {
            JsonObject jsonObject = new Gson().fromJson(source,JsonObject.class);
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(jsonObject.get("description")==null||jsonObject.get("description").isJsonNull()?null:jsonObject.get("description").getAsString());
            productDTO.setReference(jsonObject.get("reference")==null||jsonObject.get("reference").isJsonNull()?null:jsonObject.get("reference").getAsString());
            productDTO.setMark(jsonObject.get("mark")==null||jsonObject.get("mark").isJsonNull()?null:jsonObject.get("mark").getAsString());
            productDTO.setState(jsonObject.get("state")==null||jsonObject.get("state").isJsonNull()?null:jsonObject.get("state").getAsInt());
            productDTO.setProductline(jsonObject.get("productLine")==null||jsonObject.get("productLine").isJsonNull()?null:jsonObject.get("productLine").getAsLong());
            productDTO.setCategorie(jsonObject.get("categorie")==null||jsonObject.get("categorie").isJsonNull()?null:jsonObject.get("categorie").getAsLong());
            productDTO.setDesignation(jsonObject.get("designation")==null||jsonObject.get("designation").isJsonNull()?null:jsonObject.get("designation").getAsString());
            productDTO.setLevel(jsonObject.get("level")==null||jsonObject.get("level").isJsonNull()?null:jsonObject.get("level").getAsLong());
            productDTO.setPerishable(jsonObject.get("perishable")==null||jsonObject.get("perishable").isJsonNull()?null:jsonObject.get("perishable").getAsBoolean());
            productDTO.setCurrentQuantity(jsonObject.get("currentQuantity")==null||jsonObject.get("currentQuantity").isJsonNull()?null:jsonObject.get("currentQuantity").getAsFloat());
            productDTO.setMinimumThreshold(jsonObject.get("minimumThreshold")==null||jsonObject.get("minimumThreshold").isJsonNull()?null:jsonObject.get("minimumThreshold").getAsFloat());
            productDTO.setUnitPrice(jsonObject.get("unitPrice")==null||jsonObject.get("unitPrice").isJsonNull()?null:jsonObject.get("unitPrice").getAsInt());
            productDTO.setUnit(jsonObject.get("unit")==null||jsonObject.get("unit").isJsonNull()?null:jsonObject.get("unit").getAsLong());
            return productDTO;
        }catch (Exception e){
            throw  new MappingException("Posting object parse fail");
        }
    }
}
