package foodtogo.domain;

import foodtogo.cqrs.CommandBus;
import foodtogo.cqrs.DomainEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.RollbackOn;

@Configuration
@ComponentScan(basePackages = {"foodtogo.domain", "foodtogo.cqrs"})
@EnableEnversRepositories
@EnableTransactionManagement(rollbackOn = RollbackOn.ALL_EXCEPTIONS, proxyTargetClass = true)
public class DomainConfiguration {

    @Bean
    public DomainEventBus domainEventBus() {
        return null;
    }

    @Bean
    CommandBus commandBus() {
        return null;
    }
}
