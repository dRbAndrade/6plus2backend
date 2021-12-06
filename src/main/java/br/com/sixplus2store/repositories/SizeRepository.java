package br.com.sixplus2store.repositories;

import br.com.sixplus2store.models.Category;
import br.com.sixplus2store.models.Product;
import br.com.sixplus2store.models.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    Size findByName(String name);

}
