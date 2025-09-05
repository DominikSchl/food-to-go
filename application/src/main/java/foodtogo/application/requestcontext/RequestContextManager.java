package foodtogo.application.requestcontext;

import org.springframework.stereotype.Component;

@Component
public class RequestContextManager {

    private static final ThreadLocal<RequestContext> context = new ThreadLocal<>();

    public RequestContext getRequestContextOrFail() {
        RequestContext requestContext =  context.get();
        if (requestContext == null) {
            throw new IllegalStateException("RequestContext is not set");
        }
        return requestContext;
    }

    public void set(RequestContext requestContext) {
        context.set(requestContext);

    }

    public void clear() {
        context.remove();
    }
}
