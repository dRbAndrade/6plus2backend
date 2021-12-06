package br.com.sixplus2store.controllers;

import br.com.sixplus2store.dtos.ProductDTO;
import br.com.sixplus2store.services.ProductService;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable,
                                                    @RequestParam(required = false) Long category,
                                                    @RequestParam(required = false) String productSize) {
        return ResponseEntity.ok(service.findAllPaged(category,productSize,pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{id}/sizes")
    public ResponseEntity<List<String>> findSizes(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSizes(id));
    }
    @PostMapping
    public ResponseEntity<ProductDTO> persistNew(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.persistNew(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,
                                             @RequestBody ProductDTO dto) {


        return ResponseEntity.ok(service.update(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}
