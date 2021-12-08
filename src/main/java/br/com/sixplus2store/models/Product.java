package br.com.sixplus2store.models;

import br.com.sixplus2store.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String title;
    @Column(precision = 10,scale = 2,nullable = false)
    private Double price;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    List<ProductSize> sizes;

    public Product() {}

    public Product(ProductDTO dto) {

        this.id = dto.getId();
        this.title = dto.getTitle();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
        this.image = dto.getImage();
        this.category = new Category(dto.getCategory());

    }
}
