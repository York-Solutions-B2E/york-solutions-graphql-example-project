package net.yorksolutions.graphqlexamplebackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Iterable<Account> findByFirstName(String firstName);
    Iterable<Account> findByusername(String username);
}
