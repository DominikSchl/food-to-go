package foodtogo.application.rest;

import foodtogo.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{tenant}")
public class AccountController {

    private final AccountRepository accountRepository;
}
