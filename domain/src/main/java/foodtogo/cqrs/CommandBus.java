package foodtogo.cqrs;

@FunctionalInterface
public interface CommandBus {
    <R> CommandResponse<R> dispatch(Command<R> command);
}
