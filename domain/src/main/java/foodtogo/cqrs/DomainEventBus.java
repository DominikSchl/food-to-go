package foodtogo.cqrs;

@FunctionalInterface
public interface DomainEventBus {
    <D extends DomainEvent> void dispatch(D event);
}
