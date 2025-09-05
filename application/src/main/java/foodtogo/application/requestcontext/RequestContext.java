package foodtogo.application.requestcontext;

import foodtogo.application.requestcontext.tenant.Tenant;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Locale;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
public class RequestContext {
//    @Builder.Default private final UUID uuid = UUID.randomUUID();
//    private final String tenantId;
//    private final Tenant tenant;
//    private final RequestType requestType;
//    private final String requestPath;
//    private final String user;
//    private final String userId;
//    private final Locale locale;
//
//
//    @NonNull
//    public Tenant getTenantOrFail() {
//        if (tenant == null) {
//            throw new RuntimeException("unknown tenant: " + tenantId);
//        }
//        return tenant;
//    }
//
//    public enum RequestType {
//        REST_API,
//        BATCH_JOB
//    }
}
