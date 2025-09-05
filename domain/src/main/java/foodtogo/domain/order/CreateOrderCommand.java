package foodtogo.domain.order;

import foodtogo.cqrs.Command;
import foodtogo.domain.NewEntityResult;
import foodtogo.domain.restaurant.MenuItem;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateOrderCommand implements Command<NewEntityResult> {
    @NotNull MenuItem[] items;
    @NotNull double price;
    @NotNull String restaurantCode;
    String additionalInfo;
}
