package foodtogo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
@RequiredArgsConstructor
public class NewEntityResult {
    private final Long id;

    @Override
    public String toString() {
        return id != null ? id.toString() : "";
    }
}
