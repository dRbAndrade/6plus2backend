package br.com.sixplus2store.repositories;

import br.com.sixplus2store.dtos.ProductDTO;
import br.com.sixplus2store.models.Category;
import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.ProductSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
    Page<Product> findByCategory(Category category, Pageable pageable);
    @Query(value = "select * from tb_product " +
            "inner join tb_category on tb_category.id=tb_product.category_id " +
            "inner join tb_product_size on tb_product.id=tb_product_size.product_id " +
            "where tb_category.id=:category and tb_product_size.size_id=:size",nativeQuery = true)
    Page<Product> findByCategoryAndSize(@Param("category") Long category, @Param("size") Long size, Pageable page);
    @Query(value = "Select * from tb_product " +
            "inner join tb_product_size " +
            "inner join tb_size on tb_product_size.size_id=tb_size.id " +
            "where tb_product_size.product_id=tb_product.id and tb_product_size.size_id=:size",
            nativeQuery = true)
    Page<Product> findBySizes(@Param("size") Long size, Pageable pageable);
}
