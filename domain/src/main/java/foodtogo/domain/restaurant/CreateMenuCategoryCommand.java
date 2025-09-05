package foodtogo.domain.restaurant;

import foodtogo.cqrs.Command;
import foodtogo.domain.NewEntityResult;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateMenuCategoryCommand implements Command<NewEntityResult> {
    @NotNull String code;
    @NotNull String name;
}
