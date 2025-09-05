package foodtogo.domain;

import jakarta.validation.constraints.NotNull;

public interface EntityReference {
    @NotNull
    Long getId();
}
