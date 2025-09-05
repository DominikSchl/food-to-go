package foodtogo.domain.account;

import foodtogo.cqrs.Command;
import foodtogo.domain.NewEntityResult;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateAccountCommand implements Command<NewEntityResult> {
    @NotNull String email;
    @NotNull String username;
    @NotNull AccountRole role;
}
