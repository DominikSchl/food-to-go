package foodtogo.domain.order;

import foodtogo.domain.AbstractEntity;
import foodtogo.domain.restaurant.MenuItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Table
public class Order extends AbstractEntity {

    @NotNull
    MenuItem[] items;

    @NotNull
    private double price;

    @Builder.Default
    private OrderStatus status = OrderStatus.NEW;

    @NotNull
    private String restaurantCode;

    private String additionalInfo;
}
