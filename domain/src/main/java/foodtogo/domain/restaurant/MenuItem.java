package foodtogo.domain.restaurant;

import foodtogo.domain.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
public class MenuItem extends AbstractEntity {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private double price;

    @NotNull
    private String menuCategoryCode;
}
