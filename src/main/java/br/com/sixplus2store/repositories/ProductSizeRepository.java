package br.com.sixplus2store.repositories;

import br.com.sixplus2store.dtos.ProductSizeDTO;
import br.com.sixplus2store.models.ProductSize;
import br.com.sixplus2store.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {


    List<ProductSize> findBySize(Size size);

    @Query("SELECT s.name FROM ProductSize ps INNER JOIN ps.size s WHERE ps.product.id=:id ")
    List<String> findSizes(@Param("id")Long id);

    @Query("SELECT new br.com.sixplus2store.dtos.ProductSizeDTO(p,s) " +
            "FROM ProductSize ps INNER JOIN ps.product p INNER JOIN ps.size s")
    List<ProductSizeDTO> findProductSizes();

}
