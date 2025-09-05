package foodtogo.application.rest;

import foodtogo.cqrs.CommandBus;
import foodtogo.domain.NewEntityResult;
import foodtogo.domain.account.Account;
import foodtogo.domain.account.AccountRepository;
import foodtogo.domain.account.CreateAccountCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final CommandBus commandBus;

    @PostMapping("/user")
    public NewEntityResult createUser(@RequestBody @Valid CreateAccountCommand command) {
        return commandBus.dispatch(command).getResult();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Account> getUser(@PathVariable("userId") Long userId) {
        var account = accountRepository.findById(userId);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
