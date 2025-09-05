package foodtogo.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
@Import({Application.class})
public class TestApplication {

    @Bean
    public TransactionHelper transactionHelper() {
        return new TransactionHelper();
    }
}
