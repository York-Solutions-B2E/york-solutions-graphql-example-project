package net.yorksolutions.graphqlexamplebackend;

import graphql.com.google.common.collect.Iterators;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Iterable<Account> getAll(AccountFilterInputs filters) {

        if (filters != null) {
            if (filters.firstName != null) {
                return repository.findByFirstName(filters.firstName);
            }

            if (filters.username != null) {
                return repository.findByusername(filters.username);
            }
        }

        return repository.findAll();
    }

    public Account createAccount(Account accountData) {
        return repository.save(
                new Account(
                        accountData.username,
                        accountData.password,
                        accountData.firstName,
                        accountData.lastName
                )
        );
    }
}
