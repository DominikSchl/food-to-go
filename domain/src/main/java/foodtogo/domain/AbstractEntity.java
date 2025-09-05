package foodtogo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.Objects;

@SuperBuilder
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractEntity implements EntityReference {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    @NotNull
    private Long id;

    private DbStatus dbStatus = DbStatus.ACTIVE;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return getId() != null && Objects.equals(getId(), entity.getId());
    }

    @Override
    public final Long getId() {
        return id;
    }
}
