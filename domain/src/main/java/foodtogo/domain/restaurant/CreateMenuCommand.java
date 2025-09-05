package foodtogo.domain.restaurant;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateMenuCommand {
    @NotNull MenuCategory[] menuCategories;
    @NotNull MenuItem[] menuItems;
}
