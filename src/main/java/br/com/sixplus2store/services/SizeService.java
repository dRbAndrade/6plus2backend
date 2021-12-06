package br.com.sixplus2store.services;

import br.com.sixplus2store.dtos.SizeDTO;
import br.com.sixplus2store.models.Category;
import br.com.sixplus2store.models.Size;
import br.com.sixplus2store.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Transactional(readOnly = true)
    public Page<SizeDTO> findAllPaged(Pageable pageable){
        return sizeRepository.findAll(pageable).map(SizeDTO::new);
    }

    @Transactional(readOnly = true)
    public SizeDTO findById(Long id) {
        return new SizeDTO(sizeRepository.findById(id).get());
    }
}
