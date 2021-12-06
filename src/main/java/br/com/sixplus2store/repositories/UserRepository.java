package br.com.sixplus2store.repositories;

import br.com.sixplus2store.models.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<StoreUser,Long> {

    StoreUser findByUsername(String username);


}
