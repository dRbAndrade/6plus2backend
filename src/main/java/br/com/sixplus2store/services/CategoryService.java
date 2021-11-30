package br.com.sixplus2store.services;

import br.com.sixplus2store.dtos.ProductDTO;
import br.com.sixplus2store.repositories.CategoryRepository;
import br.com.sixplus2store.dtos.CategoryDTO;
import br.com.sixplus2store.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(Pageable pageable){
        return repository.findAll(pageable).map(CategoryDTO::new);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        return new CategoryDTO(repository.findById(id).get());
    }

    @Transactional
    public CategoryDTO persistNew(CategoryDTO dto){
        return new CategoryDTO(repository.save(new Category(dto)));
    }
    @Transactional
    public CategoryDTO update(long id,CategoryDTO dto){
        Category entity = repository.getById(id);
        entity.setName(dto.getName());
        return new CategoryDTO(repository.save(entity));
    }
    @Transactional
    public void delete(long id){
        repository.deleteById(id);
    }

}
