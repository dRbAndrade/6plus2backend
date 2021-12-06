package br.com.sixplus2store.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProductSizeKey implements Serializable {

    @Column(name = "product_id")
    private long productid;
    @Column(name = "size_id")
    private long sizeid;

    public ProductSizeKey() {
    }

    public ProductSizeKey(Product product, Size size) {
        this.productid = product.getId();
        this.sizeid = size.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSizeKey that = (ProductSizeKey) o;
        return productid == that.productid && sizeid == that.sizeid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productid, sizeid);
    }
}
