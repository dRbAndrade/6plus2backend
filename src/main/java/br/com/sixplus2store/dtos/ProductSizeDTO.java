package br.com.sixplus2store.dtos;

import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.ProductSizeKey;
import br.com.sixplus2store.models.Size;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class ProductSizeDTO {


    private Long productId;
    private String size;

    public ProductSizeDTO() {}

    public ProductSizeDTO(Product product,Size size) {
        this.productId = product.getId();
        this.size = size.getName();
    }
}
