package foodtogo.application.rest;

import foodtogo.cqrs.CommandBus;
import foodtogo.domain.NewEntityResult;
import foodtogo.domain.account.AccountRepository;
import foodtogo.domain.account.CreateAccountCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final CommandBus commandBus;

    @PostMapping("/user")
    public NewEntityResult createUser(@RequestBody @Valid CreateAccountCommand command) {
        return commandBus.dispatch(command).getResult();
    }
}
