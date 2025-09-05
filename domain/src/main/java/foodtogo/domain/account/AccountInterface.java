package foodtogo.domain.account;

import jakarta.validation.constraints.NotNull;

public interface AccountInterface {
    @NotNull
    String getEmail();

    @NotNull
    String getUsername();
}
