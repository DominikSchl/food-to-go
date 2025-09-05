package foodtogo.application.requestcontext.tenant;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class Tenant implements Serializable {

    private String id;
}
