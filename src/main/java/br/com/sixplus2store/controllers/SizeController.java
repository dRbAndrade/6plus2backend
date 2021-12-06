package br.com.sixplus2store.controllers;

import br.com.sixplus2store.dtos.SizeDTO;
import br.com.sixplus2store.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productSizes")
public class SizeController {

    private SizeService service;

    @Autowired
    public SizeController(SizeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<SizeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAllPaged(pageable));
    }

}
