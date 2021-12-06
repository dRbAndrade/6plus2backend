package br.com.sixplus2store.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class ProductSize implements Serializable {

    @EmbeddedId
    private ProductSizeKey id;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @MapsId("sizeId")
    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    private Integer available;

    public ProductSize() {}

    public ProductSize(Size size, Product product, Integer available) {
        this.size = size;
        this.product = product;
        this.available = available;
        this.id = new ProductSizeKey(product,size);
    }
}
