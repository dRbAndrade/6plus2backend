package br.com.sixplus2store.repositories;

import br.com.sixplus2store.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getByName(String name);

}
