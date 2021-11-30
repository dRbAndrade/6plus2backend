package br.com.sixplus2store.dtos;

import br.com.sixplus2store.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }

    public CategoryDTO(String name){
        this.name = name;
    }

}
