package br.com.sixplus2store.dtos;

import br.com.sixplus2store.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {


    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

    public ProductDTO() {}

    public ProductDTO(Product entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.category = entity.getCategory().getName();

    }
}
