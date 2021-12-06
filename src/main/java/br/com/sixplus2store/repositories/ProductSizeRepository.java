package br.com.sixplus2store.repositories;

import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.ProductSize;
import br.com.sixplus2store.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {


    List<ProductSize> findBySize(Size size);
}
