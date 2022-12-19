package net.yorksolutions.graphqlexamplebackend;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
public class AccountController {

    AccountService service;
    public AccountController(AccountService service) {
        this.service = service;
    }

    @QueryMapping
    public Iterable<Account> getAccounts( @Argument AccountFilterInputs filterInput) {
        return service.getAll(filterInput);
    }

    @MutationMapping
    public Account createAccount(@Argument Account accountInput) {
        return service.createAccount(accountInput);
    }

}

class AccountFilterInputs {
    public String username;
    public String firstName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
