package br.com.sixplus2store.services;

import br.com.sixplus2store.dtos.ProductDTO;
import br.com.sixplus2store.dtos.ProductSizeDTO;
import br.com.sixplus2store.models.Category;
import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.ProductSize;
import br.com.sixplus2store.models.Size;
import br.com.sixplus2store.repositories.CategoryRepository;
import br.com.sixplus2store.repositories.ProductRepository;
import br.com.sixplus2store.repositories.ProductSizeRepository;
import br.com.sixplus2store.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SizeRepository sizeRepository;
    private final ProductSizeRepository productSizeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, SizeRepository sizeRepository, ProductSizeRepository productSizeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.sizeRepository = sizeRepository;
        this.productSizeRepository = productSizeRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Long categoryId, String sizeNumber,Pageable pageable){
        Page<ProductDTO> response;
        Category category = categoryId==null?null:categoryRepository.getById(categoryId);
        Size size = sizeRepository.findByName(sizeNumber);
        if(category!=null&&sizeNumber!=null){
            response = productRepository
                    .findByCategoryAndSize(categoryId,size.getId(),pageable)
                    .map(ProductDTO::new);
        }
        else if(category!=null){
            response = productRepository
                    .findByCategory(category,pageable)
                    .map(ProductDTO::new);
        }
        else if (sizeNumber!=null){
            response = productRepository
                    .findBySizes(size.getId(),pageable)
                    .map(ProductDTO::new);
        }else{
            response = productRepository.findAll(pageable).map(ProductDTO::new);
        }
        return response;
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

    public List<String> findSizes(Long id) {

        return productSizeRepository.findSizes(id);

    }

    public Page<ProductDTO> findBatch(List<Long> productBatch, Pageable pageable) {
        return productRepository.findByIdIn(productBatch,pageable);
    }

    public List<ProductSizeDTO> findAllSizes() {
        return productSizeRepository.findProductSizes();
    }
}
