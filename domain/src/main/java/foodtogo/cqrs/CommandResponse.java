package foodtogo.cqrs;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
public class CommandResponse<R> {

    private final R result;
    private final List<DomainEvent> domainEvents;
    private final List<Exception> followUpErrors = new ArrayList<>();
    private final List<Object> followUpResults = new ArrayList<>();

    public CommandResponse(R result) {
        this(result, new ArrayList<>());
    }

    public CommandResponse(R result, DomainEvent... domainEvents) {
        this(result, Stream.of(domainEvents).toList());
    }

    public CommandResponse(R result, List<DomainEvent> domainEvents) {
        this.result = result;
        this.domainEvents = domainEvents;
    }
}
