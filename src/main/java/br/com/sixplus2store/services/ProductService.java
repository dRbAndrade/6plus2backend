package br.com.sixplus2store.services;

import br.com.sixplus2store.dtos.ProductDTO;
import br.com.sixplus2store.models.Category;
import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.repositories.CategoryRepository;
import br.com.sixplus2store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable){
        return productRepository.findAll(pageable).map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO persistNew(ProductDTO dto){
        Category category = categoryRepository.getByName(dto.getCategory());
        Product product = new Product(dto);
        product.setCategory(category);
        return new ProductDTO(productRepository.save(product));
    }
    @Transactional
    public ProductDTO update(long id,ProductDTO dto){
        Product entity = productRepository.getById(id);
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setCategory(new Category(dto.getCategory()));
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getImage());
        return new ProductDTO(productRepository.save(entity));
    }
    @Transactional
    public void delete(long id){
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return new ProductDTO(productRepository.findById(id).get());
    }
}
