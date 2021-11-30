package br.com.sixplus2store.models;

import br.com.sixplus2store.dtos.CategoryDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,unique = true,nullable = false)
    private String name;

    public Category() {
    }

    public Category(CategoryDTO dto) {
        this.id = dto.getId()==null?null:dto.getId();
        this.name = dto.getName();
    }

    public Category(String name) {
        this.name = name;
    }
}
