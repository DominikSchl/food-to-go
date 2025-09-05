package foodtogo.application;

import org.springframework.transaction.annotation.Transactional;

public class TransactionHelper {

    @Transactional
    public void runInTransaction(Runnable runnable) {
        runnable.run();
    }
}
