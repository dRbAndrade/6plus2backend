package br.com.sixplus2store.dtos;

import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeDTO {


    private Long id;
    private String name;
    public SizeDTO() {}

    public SizeDTO(Size entity) {

        this.id = entity.getId();
        this.name = entity.getName();

    }
}
